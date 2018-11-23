package root.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import root.async.UserAsyncDataHandler;
import root.configConstant.TimConfigProperties;
import root.dto.LoginDto;
import root.exception.CheckParamException;
import root.mapper.UsersMapper;
import root.model.Users;
import root.param.LoginParam;
import root.param.RegisterParam;
import root.param.ValidateParam;
import root.redis.RedisOperator;
import root.util.DtoUtil;
import root.util.MD5Util;
import root.util.RandomUtil;
import root.util.RegexUtil;
import root.util.ValidatorUtil;

@Service
public class LoginService {
	
	@Resource
	private RedisOperator redisOperator;
	@Resource
	private UsersMapper usersMapper;
	@Resource
	private TimConfigProperties timConfigProperties;
	@Resource
	private UserAsyncDataHandler userAsyncDataHandler;
	/**
	 * 校验请求录入参数
	 * 校验手机号形式
	 * 是否存在手机号注册用户
	 * 存放手机号与验证码信息hset(hkey: telephone, filed: validateCode, value: phone)
	 * 存放前删除redis中的数据
	 * 发送验证码,存放redis数据并设置过期时间
	 * @param param
	 * @return
	 */
	public String validatePhone(ValidateParam param) {
		ValidatorUtil.check(param);
		String telephone = param.getTelephone();
		if(!RegexUtil.regexPhone(telephone)) {throw new CheckParamException("手机号形式错误");}
		String validateCode = RandomUtil.getPhoneValidate();
		int count = usersMapper.countByTelePhone(telephone);
		if (count > 0) {throw new CheckParamException("该手机号以绑定账号");}
		redisOperator.del(MD5Util.encrypt(param.getTelephone()));
		redisOperator.hset(MD5Util.encrypt(param.getTelephone()), MD5Util.encrypt(validateCode), 
				MD5Util.encrypt(param.getTelephone()));
		redisOperator.expire(MD5Util.encrypt(param.getTelephone()), timConfigProperties.getLogin().getValidateCodeTimeout());
		return validateCode;
	}
	
	/**
	 * 校验请求录入参数
	 * 校验验证码和手机号
	 * 是否存在手机号注册用户
	 * 存出redis中md5 phone
	 * 判定空和hget的值
	 * @param param
	 */
	public void validateCode(ValidateParam param) {
		ValidatorUtil.check(param);
		if (StringUtils.isBlank(param.getValidateCode())) {throw new CheckParamException("验证码不能为空");}
		if(!RegexUtil.regexPhone(param.getTelephone())) {throw new CheckParamException("手机号形式错误");}
		int count = usersMapper.countByTelePhone(param.getTelephone());
		if (count > 0) {throw new CheckParamException("该手机号以绑定账号");}
		String dbPhone = redisOperator.hget(MD5Util.encrypt(param.getTelephone()), MD5Util.encrypt(param.getValidateCode()));
		if (dbPhone == null || !MD5Util.encrypt(param.getTelephone()).equals(dbPhone)) {
			throw new CheckParamException("验证码错误");
		}
	}

	/**
	 * 检查参数
	 * 检查密码是否一致
	 * 检查手机号是否以绑定
	 * 检查验证码是否正确
	 * 删除redis缓存
	 * 生成QQ号,且QQ号不允许重复
	 * 返回用户信息
	 * ! 异步生成二维码并上传至七牛云
	 * @param param
	 */
	@Transactional
	public LoginDto register(RegisterParam param) {
		ValidatorUtil.check(param);
		if(!RegexUtil.regexPhone(param.getTelephone())) {throw new CheckParamException("手机号形式错误");}
		if(!param.getPassword().equals(param.getRePassword())) {throw new CheckParamException("两次密码不一致");}
		int count = usersMapper.countByTelePhone(param.getTelephone());
		if (count > 0) {throw new CheckParamException("该手机号以绑定账号");}
		String dbPhone = redisOperator.hget(MD5Util.encrypt(param.getTelephone()), MD5Util.encrypt(param.getValidateCode()));
		if (dbPhone == null || !MD5Util.encrypt(param.getTelephone()).equals(dbPhone)) {throw new CheckParamException("注册时间过期,请重新尝试注册");}
		redisOperator.del(MD5Util.encrypt(param.getTelephone()));
		String qqNumber = this.getQQNumber();
		Users user = Users.builder().id(RandomUtil.getUUID()).qqNumber(qqNumber).nickname(param.getNickname()).password(MD5Util.encrypt(param.getPassword()))
		.faceImageCut(timConfigProperties.getUserDefault().getDefaultAvatar()).faceImageBig(timConfigProperties.getUserDefault().getDefaultAvatar()).telephone(param.getTelephone())
		.createTime(new Date()).appId(param.getAppId()).description("").build();
		usersMapper.insertSelective(user);
		String uploadQrCode = qqNumber + ".png";
		String dbQrCode = uploadQrCode + "?v=" + new Date().getTime();
		userAsyncDataHandler.uploadQrCode(qqNumber, uploadQrCode, dbQrCode);
		LoginDto loginDto = DtoUtil.adapt(new LoginDto(), user);
		loginDto.setPassword("");
		loginDto.setAppId("");
		loginDto.setQrcode(dbQrCode);
		return loginDto;
	}
	
	/**
	 * 检查请求录入参数
	 * 是否存在用户
	 * 比对密码
	 * 记录登录设备的标识码
	 * 登录并返回用户信息
	 * @param param
	 */
	public LoginDto login(LoginParam param) {
		ValidatorUtil.check(param);
		if (!StringUtils.isNumeric(param.getLoginname())) {throw new CheckParamException("账户必须是QQ号或手机号");}
		int count = usersMapper.countByQQNumberOrPhone(param.getLoginname());
		if (count == 0) {throw new CheckParamException("登录账户不存在,请先注册");}
		Users user = usersMapper.getByQQNumberOrPhone(param.getLoginname());
		if (!user.getPassword().equals(MD5Util.encrypt(param.getPassword()))) {throw new CheckParamException("密码错误");}
		user.setAppId(param.getAppId());
		usersMapper.updateByPrimaryKeySelective(user);
		LoginDto loginDto = DtoUtil.adapt(new LoginDto(), user);
		loginDto.setPassword(""); 
		loginDto.setAppId("");
		return loginDto;
	}
	
	/**
	 * 遍历获取唯一QQ号
	 * @return
	 */
	private String getQQNumber() {
		boolean flag = true;
		String qqNumber = null;
		while(flag) {
			qqNumber = RandomUtil.getQQNumber();
			int count = usersMapper.countByQQNumber(qqNumber);
			if (count == 0) {flag = false;}
		}
		return qqNumber;
	}
	
}
