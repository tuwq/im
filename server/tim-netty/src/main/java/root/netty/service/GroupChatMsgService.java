package root.netty.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.beust.jcommander.internal.Lists;

import root.dto.GroupChatContentDto;
import root.enums.ChatMsgStatusEnum;
import root.exception.CheckParamException;
import root.mapper.GroupAcceptChatContentMapper;
import root.mapper.GroupSendChatContentMapper;
import root.mapper.GroupUsersMapper;
import root.model.GroupAcceptChatContent;
import root.model.GroupSendChatContent;
import root.model.Users;
import root.netty.dto.AccepetChatContent;
import root.netty.dto.AcceptMsgIdBindMember;
import root.netty.enums.AcceptTypeEnums;
import root.util.RandomUtil;

@Service
public class GroupChatMsgService {

	@Resource
	private GroupSendChatContentMapper groupSendChatContentMapper;
	@Resource
	private GroupAcceptChatContentMapper groupAcceptChatContentMapper;
	@Resource
	private GroupUsersMapper groupUsersMapper;
	/**
	 * 保存群聊发送文字
	 * @param accepetChatContent
	 * @return
	 */
	public String saveGroupSendMsgContent(AccepetChatContent accepetChatContent) {
		String uuid = RandomUtil.getUUID();
		String senderId = accepetChatContent.getSenderId();
		String groupId = accepetChatContent.getAcceptId();
		String content = accepetChatContent.getContent();
		GroupSendChatContent build = GroupSendChatContent.builder()
		.id(uuid).sendUserId(senderId).acceptGroupId(groupId)
		.content(content).contentType(AcceptTypeEnums.TEXT.getType())
		.createTime(new Date()).build();
		groupSendChatContentMapper.insertSelective(build);
		return uuid;
	}
	
	/**
	 * 保存群聊发送图片
	 * @param accepetChatContent
	 * @return
	 */
	public String saveGroupSendImageContent(AccepetChatContent accepetChatContent) {
		String uuid = RandomUtil.getUUID();
		String senderId = accepetChatContent.getSenderId();
		String groupId = accepetChatContent.getAcceptId();
		String content = accepetChatContent.getContent();
		GroupSendChatContent build = GroupSendChatContent.builder()
		.id(uuid).sendUserId(senderId).acceptGroupId(groupId)
		.content(content).contentType(AcceptTypeEnums.IMAGE.getType())
		.createTime(new Date()).build();
		groupSendChatContentMapper.insertSelective(build);
		return uuid;
	}
	
	
	/**
	 * 获取群友们的id
	 * @param acceptId
	 * @return
	 */
	public List<String> getGroupMemberList(String groupId) {
		return groupUsersMapper.memberIdListByGroupId(groupId);
	}
	/**
	 * 批量插入群聊接收消息
	 * @param groupSendMsgContentId
	 * @param groupMemberIdList
	 * @return
	 */
	public List<AcceptMsgIdBindMember> saveBatchGroupAcceptMsgContent(String groupSendContentId, AccepetChatContent accepetChatContent, List<String> groupMemberIdList) {
		List<AcceptMsgIdBindMember> bindList = Lists.newArrayList();
		List<GroupAcceptChatContent> groupAcceptChatContentList = Lists.newArrayList();
		String senderId = accepetChatContent.getSenderId();
		String acceptGroupId = accepetChatContent.getAcceptId();
		String content = accepetChatContent.getContent();
		groupMemberIdList.stream().forEach(memberId -> {
			String uuid = RandomUtil.getUUID();
			GroupAcceptChatContent groupAcceptChatContent = GroupAcceptChatContent.builder()
			.id(uuid).groupSendContentId(groupSendContentId)
			.sendUserId(senderId)
			.acceptGroupId(acceptGroupId).acceptUserId(memberId)
			.content(content).contentType(AcceptTypeEnums.TEXT.getType()).signFlag(ChatMsgStatusEnum.NOSIGN.getStatusCode())
			.createTime(new Date()).build();
			AcceptMsgIdBindMember bind = AcceptMsgIdBindMember.builder()
			.acceptMsgId(uuid).memberId(memberId).build();
			groupAcceptChatContentList.add(groupAcceptChatContent);
			bindList.add(bind);
		});
		groupAcceptChatContentMapper.inertBatch(groupAcceptChatContentList);
		return bindList;
	}
	
	/**
	 * 批量插入群聊接收消息图片
	 * @param groupSendContentId
	 * @param accepetChatContent
	 * @param groupMemberIdList
	 * @return
	 */
	public List<AcceptMsgIdBindMember> saveBatchGroupAcceptImageContent(String groupSendContentId, AccepetChatContent accepetChatContent, List<String> groupMemberIdList) {
		List<AcceptMsgIdBindMember> bindList = Lists.newArrayList();
		List<GroupAcceptChatContent> groupAcceptChatContentList = Lists.newArrayList();
		String senderId = accepetChatContent.getSenderId();
		String acceptGroupId = accepetChatContent.getAcceptId();
		String content = accepetChatContent.getContent();
		groupMemberIdList.stream().forEach(memberId -> {
			String uuid = RandomUtil.getUUID();
			GroupAcceptChatContent groupAcceptChatContent = GroupAcceptChatContent.builder()
			.id(uuid).groupSendContentId(groupSendContentId)
			.sendUserId(senderId)
			.acceptGroupId(acceptGroupId).acceptUserId(memberId)
			.content(content).contentType(AcceptTypeEnums.IMAGE.getType()).signFlag(ChatMsgStatusEnum.NOSIGN.getStatusCode())
			.createTime(new Date()).build();
			AcceptMsgIdBindMember bind = AcceptMsgIdBindMember.builder()
			.acceptMsgId(uuid).memberId(memberId).build();
			groupAcceptChatContentList.add(groupAcceptChatContent);
			bindList.add(bind);
		});
		groupAcceptChatContentMapper.inertBatch(groupAcceptChatContentList);
		return bindList;
	} 
	
	/**
	 * 获取未读的群聊消息
	 * 获取发送者的信息
	 * @param acceptUserId
	 */
	public List<GroupChatContentDto> getNoReadChatMsgList(String acceptUserId) {
		if (StringUtils.isBlank(acceptUserId)) throw new CheckParamException("用户id不能为空");
		List<GroupChatContentDto> list = groupAcceptChatContentMapper.getNoReadListByAcceptUserId(acceptUserId, ChatMsgStatusEnum.NOSIGN.getStatusCode());
		return list;
	}
}
