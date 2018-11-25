package root.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import root.exception.CheckParamException;
import root.mapper.GroupUsersMapper;
import root.mapper.GroupsMapper;
import root.mapper.UsersMapper;
import root.model.GroupUsers;
import root.param.JoinGroupRequestParam;
import root.util.RandomUtil;
import root.util.ValidatorUtil;

@Service
public class GroupRequestService {
	
	@Resource
	private GroupUsersMapper groupUsersMapper;
	@Resource
	private GroupsMapper groupsMapper;
	@Resource
	private UsersMapper usersMapper;
	
	/**
	 * 入群请求
	 * 检查参数
	 * 是否已入群
	 * 直接入群,不需要申请..
	 * 群人数加一
	 * @param param
	 */
	public void join(JoinGroupRequestParam param) {
		ValidatorUtil.check(param);
		String meId = param.getMeId();
		String groupId = param.getGroupId();
		int meExist = usersMapper.countById(meId);
		if (meExist == 0) throw new CheckParamException("个人用户不存在"); 
		int groupExist = groupsMapper.countById(groupId);
		if (groupExist == 0) throw new CheckParamException("群聊不存在");
		int joined = groupUsersMapper.isJoined(groupId, meId);
		if (joined > 0) throw new CheckParamException("已入该群,请勿再次操作"); 
		GroupUsers groupUsers = GroupUsers.builder()
		.id(RandomUtil.getUUID()).createTime(new Date())
		.groupId(groupId).userId(meId).build();
		groupUsersMapper.insertSelective(groupUsers);
		groupsMapper.incrUserSum(groupId);
	}
	
}
