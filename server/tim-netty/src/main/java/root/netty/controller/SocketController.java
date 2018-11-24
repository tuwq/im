package root.netty.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import root.netty.NettyChannelGroup;
import root.netty.NettyStorage;
import root.netty.annotations.SocketMapping;
import root.netty.dto.AccepetChatContent;
import root.netty.dto.SocketData;
import root.netty.dto.SocketResult;
import root.netty.enums.WebSocketRequestConstant;
import root.netty.enums.WebSocketResultContant;
import root.netty.service.SingleChatMsgService;
import root.util.ApplicationContextUtil;
import root.util.JsonUtils;

public class SocketController {
	
	private SingleChatMsgService singleChatMsgService = ApplicationContextUtil.popBean(SingleChatMsgService.class);
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
	 * ! channel是否在netty的channel存在
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
		Channel currentChannel = ctx.channel();
		String chatMsgIdsStr = socketData.getAccepetChatContent().getContent();
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
}
