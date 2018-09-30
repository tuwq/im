package root.netty.controller;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import root.netty.NettyStorage;
import root.netty.annotations.SocketMapping;
import root.netty.dto.SocketData;
import root.netty.dto.SocketResult;
import root.util.JsonUtils;

public class SocketController {
	
	@SocketMapping("A")
	public void acceptA(SocketData socketData,ChannelHandlerContext ctx, TextWebSocketFrame msg) {
		Channel currentChannel = ctx.channel();
		SocketResult result = SocketResult.builder().action(socketData.getAction()+"R").result(socketData.getAction()+"R").build();
		currentChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(result)));
		System.err.println("acceptA");
	}
	
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
