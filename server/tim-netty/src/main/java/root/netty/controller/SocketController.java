package root.netty.controller;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import root.enums.SingleRequestEnum;
import root.netty.NettyStorage;
import root.netty.annotations.SocketMapping;
import root.netty.dto.AccepetChatContent;
import root.netty.dto.SocketData;
import root.netty.dto.SocketResult;
import root.netty.enums.WebSocketConstant;
import root.util.JsonUtils;

public class SocketController {
	
	/**
	 * 发送私聊消息
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping(WebSocketConstant.SingleChatSendMsg)
	public void acceptA(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		Channel currentChannel = ctx.channel();
		System.out.println(socketData.getAction());
		System.out.println(socketData.getExtendFields());
		AccepetChatContent acceptChatContent = socketData.getAccepetChatContent();
		System.out.println(acceptChatContent.getSendId());
		System.out.println(acceptChatContent.getAcceptId());
		System.out.println(acceptChatContent.getContent());
		System.out.println(acceptChatContent.getContentForByte());
		System.out.println(acceptChatContent.getContentType());
	}
	
	/**
	 * 打开连接
	 * @param socketData
	 * @param ctx
	 * @param msg
	 */
	@SocketMapping("B")
	public void acceptB(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		Channel currentChannel = ctx.channel();
		SocketResult result = SocketResult.builder().action(socketData.getAction()+"R").result(socketData.getAction()+"R").build();
		currentChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(result)));
		System.err.println("acceptB");
	}

	@SocketMapping("C")
	public void acceptC(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		Channel currentChannel = ctx.channel();
		SocketResult result = SocketResult.builder().action(socketData.getAction()+"R").result(socketData.getAction()+"R").build();
		currentChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(result)));
		System.err.println("acceptC");
	}

	@SocketMapping("D")
	public void acceptD(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		Channel currentChannel = ctx.channel();
		SocketResult result = SocketResult.builder().action(socketData.getAction()+"R").result(socketData.getAction()+"R").build();
		currentChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(result)));
		System.err.println("acceptD");
	}
}
