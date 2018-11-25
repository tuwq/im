package root.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import root.dto.MyFriendUserDto;
import root.dto.UsersDto;
import root.exception.CheckParamException;
import root.mapper.SingleUsersMapper;
import root.mapper.UsersMapper;
import root.model.Users;
import root.util.DtoUtil;

@Service
public class FindSingleService {

	@Resource
	private UsersMapper usersMapper;
	@Resource
	private SingleUsersMapper singleUsersMapper;
	
	/**
	 * 寻找用户,根据QQ号/手机号/昵称
	 * @param targetInfo
	 * @return
	 */
	public List<UsersDto> list(String targetInfo) {
		if (StringUtils.isBlank(targetInfo)) throw new CheckParamException("不能为空值");
		List<Users> list = usersMapper.findByQQNumberOrPhoneOrNickname(targetInfo);
		List<UsersDto> data = list.stream().map(item -> DtoUtil.adapt(new UsersDto(), item)).collect(Collectors.toList());
		return data;
	}
	/**
	 * 查询某用户信息
	 * 是否已是好友
	 * @param userId
	 * @param meId 
	 * @return
	 */
	public UsersDto id(String userId, String meId) {
		if (StringUtils.isBlank(userId)) throw new CheckParamException("不能为空值");
		Users user = usersMapper.selectByPrimaryKey(userId);
		if (user == null) throw new CheckParamException("用户不存在");
		UsersDto userDto = DtoUtil.adapt(new UsersDto(), user);
		int friended = singleUsersMapper.isMyFriend(meId, userId);
		userDto.setFriended(friended>0?true:false);
		return userDto;
	}
	/**
	 * 查询某用户信息,根据QQ号码
	 * @param qqNumber
	 * @return
	 */
	public UsersDto qqNumber(String qqNumber) {
		if (StringUtils.isBlank(qqNumber)) throw new CheckParamException("不能为空值");
		Users user = usersMapper.getByQQNumber(qqNumber);
		if (user == null) throw new CheckParamException("用户不存在");
		return DtoUtil.adapt(new UsersDto(), user);
	}
	/**
	 * 查询某用户所有好友信息
	 * 用户是否存在
	 * @param userId
	 * @return
	 */
	public List<MyFriendUserDto> myFrientList(String userId) {
		if (StringUtils.isBlank(userId)) throw new CheckParamException("不能为空值");
		int count = usersMapper.countById(userId);
		if (count == 0) throw new CheckParamException("用户不存在");
		List<MyFriendUserDto> list = singleUsersMapper.getWithMyFriend(userId);
		return list;
	}
}
