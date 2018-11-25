package root.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.validation.GroupDefinitionException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import root.dto.GroupsDto;
import root.dto.UsersDto;
import root.exception.CheckParamException;
import root.mapper.GroupUsersMapper;
import root.mapper.GroupsMapper;
import root.model.Groups;
import root.model.Users;
import root.util.DtoUtil;

@Service
public class FindGroupService {
	
	@Resource
	private GroupsMapper groupsMapper;
	@Resource
	private GroupUsersMapper groupUsersMapper;
	
	/**
	 * 群号群名称查找群
	 * @param targetInfo
	 * @return
	 */
	public List<Groups> list(String targetInfo) {
		if (StringUtils.isBlank(targetInfo)) throw new CheckParamException("不能为空值");
		List<Groups> list = groupsMapper.findByGroupNumberOrGroupName(targetInfo);
		return list;
	}
	/**
	 * 获取群信息
	 * 获取群友相关信息
	 * 我是否已经加入了该群
	 * @param meId 
	 * @param id
	 * @return
	 */
	public GroupsDto id(String groupId, String meId) {
		if (StringUtils.isBlank(groupId)) throw new CheckParamException("群id不能为空值");
		if (StringUtils.isBlank(groupId)) throw new CheckParamException("本人id不能为空值");
		Groups group = groupsMapper.selectByPrimaryKey(groupId);
		if (group == null) throw new CheckParamException("群不存在");
		GroupsDto groupsDto = DtoUtil.adapt(new GroupsDto(), group);
		List<Users> memberList = groupUsersMapper.findGroupMemberInfo(groupId);
		List<UsersDto> memberDtoList = memberList.stream().map(member -> DtoUtil.adapt(new UsersDto(), member)).collect(Collectors.toList());
		groupsDto.setMemberList(memberDtoList);
		boolean isJoined = false;
		int count = groupUsersMapper.isJoined(groupId, meId);
		if(count > 0) isJoined = true;
		groupsDto.setJoined(isJoined);
		return groupsDto;
	}

}
