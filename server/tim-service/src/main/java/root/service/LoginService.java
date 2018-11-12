package root.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;

import root.configConstant.TimConfigProperties;
import root.exception.CheckParamException;
import root.mapper.UsersMapper;
import root.model.Users;
import root.param.RegisterParam;
import root.param.ValidateParam;
import root.redis.RedisOperator;
import root.util.FileUtils;
import root.util.MD5Util;
import root.util.QRCodeUtils;
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
	private QRCodeUtils qrCodeUtils;
	/**
	 * 校验请求录入参数
	 * 校验手机号形式
	 * 是否存在手机号注册用户
	 * 存放手机号与验证码信息hset(hkey: telephone, filed: validateCode, value: phone)
	 * 存放前删除redis中的数据
	 * 发送验证码
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
		return validateCode;
	}
	
	/**
	 * 校验请求录入参数
	 * 校验验证码和手机号
	 * 是否存在手机号注册用户
	 * 存出redis中md5 phone
	 * 判定空和hget的值
	 * 删除redis中的数据
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
		redisOperator.del(MD5Util.encrypt(param.getTelephone()));
	}

	/**
	 * 检查参数
	 * 检查密码是否一致
	 * 检查手机号是否以绑定
	 * 生成QQ号,且QQ号不允许重复
	 * @param param
	 */
	@Transactional
	public void register(RegisterParam param) {
		ValidatorUtil.check(param);
		if(!RegexUtil.regexPhone(param.getTelephone())) {throw new CheckParamException("手机号形式错误");}
		if(!param.getPassword().equals(param.getRePassword())) {throw new CheckParamException("两次密码不一致");}
		int count = usersMapper.countByTelePhone(param.getTelephone());
		if (count > 0) {throw new CheckParamException("该手机号以绑定账号");}
		Users.builder().nickname(param.getNickname()).password(MD5Util.encrypt(param.getPassword()))
		.faceImage(timConfigProperties.getUserDefault().getDefaultAvatar()).telephone(param.getTelephone())
		.createTime(new Date())
		.qqNumber(this.getQQNumber()).build();
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
			if (count > 0) {flag = false;}
		}
		return qqNumber;
	}
	
	public void buildQRCode() {
		String qrCodePath = "D://timeQRCode/"+"123"+"_qrcode.png";
		String value = MD5Util.encrypt("123");
		qrCodeUtils.createQRCode(qrCodePath, "qrcode_"+value);
		MultipartFile multipartFile = FileUtils.fileToMultipart(qrCodePath);
	}
}
