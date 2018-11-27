package root.netty.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import root.dto.UsersDto;
import root.mapper.UsersMapper;
import root.model.Users;
import root.netty.NettyChannelGroup;
import root.netty.NettyStorage;
import root.netty.annotations.SocketMapping;
import root.netty.dto.AccepetChatContent;
import root.netty.dto.AcceptMsgIdBindMember;
import root.netty.dto.SocketData;
import root.netty.dto.SocketResult;
import root.netty.enums.WebSocketRequestConstant;
import root.netty.enums.WebSocketResultContant;
import root.netty.service.GroupAcceptChatContentService;
import root.netty.service.GroupChatMsgService;
import root.netty.service.SingleChatMsgService;
import root.util.ApplicationContextUtil;
import root.util.Base64Util;
import root.util.DtoUtil;
import root.util.JsonUtils;
import root.util.RandomUtil;

public class SocketController {
	
	private SingleChatMsgService singleChatMsgService = ApplicationContextUtil.popBean(SingleChatMsgService.class);
	private GroupChatMsgService groupChatMsgService = ApplicationContextUtil.popBean(GroupChatMsgService.class);
	private UsersMapper usersMapper = ApplicationContextUtil.popBean(UsersMapper.class);
	private GroupAcceptChatContentService groupAcceptChatContentService = ApplicationContextUtil.popBean(GroupAcceptChatContentService.class);
	/**
	 * 打开连接
	 * 连接用户关系入concurrentHashMap
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.OpenWebsocket)
	public void openWebsocket(SocketData socketData, ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		Channel currentChannel = ctx.channel();
		String sendId = socketData.getAccepetChatContent().getSenderId();
		NettyStorage.put(sendId, currentChannel);
		// NettyStorage.output();
	}
	/**
	 * 心跳连接
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.KeepALive)
	public void keepALive(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {

	}
	/**
	 * 发送私聊消息
	 * 保存聊天消息
	 * 向接收者推送消息
	 * ! 接收者未上线
	 * ! 用户channel是否在netty的channel存在
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.SingleChatSendMsg)
	public void singleChatSendMsg(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		Channel currentChannel = ctx.channel();
		AccepetChatContent acceptChatContent = socketData.getAccepetChatContent();
		String content = acceptChatContent.getContent();
		String sendId = acceptChatContent.getSenderId();
		String acceptId = acceptChatContent.getAcceptId();
		String singleChatMsgId = singleChatMsgService.saveSingleChatMsg(acceptChatContent);
		Channel acceptChannel = NettyStorage.get(acceptId);
		if (acceptChannel == null) {
			
		} else {
			ChannelId channelId = acceptChannel.id();
			Channel findChannel = NettyChannelGroup.groups.find(channelId);
			if (findChannel != null) {
				acceptChatContent.setContentId(singleChatMsgId);
				SocketResult socketResult = SocketResult.success(WebSocketResultContant.AcceptSingleChatMsg, acceptChatContent);
				findChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(socketResult)));
			} else {
				
			}
		}
	}
	/**
	 * 批量签收私聊消息
	 * 以逗号分隔消息id
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.SingleSigningMsg)
	public void singleSigningMsg(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		String chatMsgIdsStr = socketData.getAccepetChatContent().getContentId();
		String[] chatMsgIdArray = chatMsgIdsStr.split(",");
		List<String> msgIdList = new ArrayList<String>();
		for (String msgId : chatMsgIdArray) {
			if (StringUtils.isNotBlank(msgId)) {
				msgIdList.add(msgId);
			}
		}
		if (msgIdList != null && !msgIdList.isEmpty() && msgIdList.size() > 0) {
			singleChatMsgService.batchUpdateSignStatus(msgIdList);
		}
	}
	
	/**
	 * 发送群聊消息
	 * 保存群聊消息
	 * 让群友们接收消息
	 * ! 接收者未上线
	 * ! 发送者的相关信息
	 * ! 用户channel是否在netty的channel存在
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.GroupChatSendMsg)
	public void groupChatMsg(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		AccepetChatContent accepetChatContent = socketData.getAccepetChatContent();
		String groupSendContentId = groupChatMsgService.saveGroupSendMsgContent(accepetChatContent);
		List<String> groupMemberIdList = groupChatMsgService.getGroupMemberList(accepetChatContent.getAcceptId());
		List<AcceptMsgIdBindMember> acceptMsgBindMemberList = groupChatMsgService.saveBatchGroupAcceptMsgContent(groupSendContentId, 
				accepetChatContent, groupMemberIdList);
		Users sender = usersMapper.selectByPrimaryKey(accepetChatContent.getSenderId());
		acceptMsgBindMemberList.stream().forEach(item -> {
			String memberId = item.getMemberId();
			String acceptMsgId = item.getAcceptMsgId();
			Channel memberChannel = NettyStorage.get(memberId);
			if (memberChannel != null) {
				Channel findChannel = NettyChannelGroup.groups.find(memberChannel.id());
				if (findChannel != null) {
					accepetChatContent.setContentId(acceptMsgId);
					accepetChatContent.setSenderId(JsonUtils.objectToJson(DtoUtil.adapt(new UsersDto(), sender)));
					SocketResult socketResult = SocketResult.success(WebSocketResultContant.AcceptGroupChatMsg, accepetChatContent);
					findChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(socketResult)));
				}
			}
		});
	}
	
	/**
	 * 签收群聊接收消息
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.GroupSigningMsg)
	public void groupSigningMsg(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		String acceptMsgIdsStr = socketData.getAccepetChatContent().getContentId();
		String[] acceptMsgIdArray = acceptMsgIdsStr.split(",");
		List<String> msgIdList = new ArrayList<String>();
		for (String msgId : acceptMsgIdArray) {
			if (StringUtils.isNotBlank(msgId)) {
				msgIdList.add(msgId);
			}
		}
		if (msgIdList != null && !msgIdList.isEmpty() && msgIdList.size() > 0) {
			groupAcceptChatContentService.batchUpdateSignStatus(msgIdList);
		}
	}
	
	/**
	 * 接收私聊图片
	 * 保存私聊消息
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.SingleChatSendImage)
	public void singleChatSendImage(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		AccepetChatContent accepetChatContent = socketData.getAccepetChatContent();
		String acceptId = accepetChatContent.getAcceptId();
		String singleChatMsgId = singleChatMsgService.saveSingleChatImage(accepetChatContent);
		Channel acceptChannel = NettyStorage.get(acceptId);
		if (acceptChannel == null) {
		} else {
			ChannelId channelId = acceptChannel.id();
			Channel findChannel = NettyChannelGroup.groups.find(channelId);
			if (findChannel != null) {
				accepetChatContent.setContentId(singleChatMsgId);
				SocketResult socketResult = SocketResult.success(WebSocketResultContant.AcceptSingleChatImage, accepetChatContent);
				findChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(socketResult)));
			} else {
				
			}
		}
	}
	
	/**
	 * 发送群聊图片
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketRequestConstant.GroupChatSendImage)
	public void groupChatSendImage(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		AccepetChatContent accepetChatContent = socketData.getAccepetChatContent();
		String groupSendContentId = groupChatMsgService.saveGroupSendImageContent(accepetChatContent);
		List<String> groupMemberIdList = groupChatMsgService.getGroupMemberList(accepetChatContent.getAcceptId());
		List<AcceptMsgIdBindMember> acceptMsgBindMemberList = groupChatMsgService.saveBatchGroupAcceptImageContent(groupSendContentId, 
				accepetChatContent, groupMemberIdList);
		Users sender = usersMapper.selectByPrimaryKey(accepetChatContent.getSenderId());
		acceptMsgBindMemberList.stream().forEach(item -> {
			String memberId = item.getMemberId();
			String acceptMsgId = item.getAcceptMsgId();
			Channel memberChannel = NettyStorage.get(memberId);
			if (memberChannel != null) {
				Channel findChannel = NettyChannelGroup.groups.find(memberChannel.id());
				if (findChannel != null) {
					accepetChatContent.setContentId(acceptMsgId);
					accepetChatContent.setSenderId(JsonUtils.objectToJson(DtoUtil.adapt(new UsersDto(), sender)));
					SocketResult socketResult = SocketResult.success(WebSocketResultContant.AcceptGroupChatImage, accepetChatContent);
					findChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(socketResult)));
				}
			}
		});
	}
}
