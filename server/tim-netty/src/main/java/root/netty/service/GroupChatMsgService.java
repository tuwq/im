package root.netty.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beust.jcommander.internal.Lists;

import root.enums.ChatMsgStatusEnum;
import root.mapper.GroupAcceptChatContentMapper;
import root.mapper.GroupSendChatContentMapper;
import root.mapper.GroupUsersMapper;
import root.model.GroupAcceptChatContent;
import root.model.GroupSendChatContent;
import root.model.Users;
import root.netty.dto.AccepetChatContent;
import root.netty.dto.AcceptMsgIdBindMember;
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
	 * 保存群聊发送消息
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
		.content(content).createTime(new Date()).build();
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
		String acceptGroupId = accepetChatContent.getAcceptId();
		String content = accepetChatContent.getContent();
		groupMemberIdList.stream().forEach(memberId -> {
			String uuid = RandomUtil.getUUID();
			GroupAcceptChatContent groupAcceptChatContent = GroupAcceptChatContent.builder()
			.id(uuid).groupSendContentId(groupSendContentId)
			.acceptGroupId(acceptGroupId).acceptUserId(memberId)
			.content(content).signFlag(ChatMsgStatusEnum.NOSIGN.getStatusCode())
			.createTime(new Date()).build();
			AcceptMsgIdBindMember bind = AcceptMsgIdBindMember.builder()
			.acceptMsgId(uuid).memberId(memberId).build();
			groupAcceptChatContentList.add(groupAcceptChatContent);
			bindList.add(bind);
		});
		groupAcceptChatContentMapper.inertBatch(groupAcceptChatContentList);
		return bindList;
	}
}
