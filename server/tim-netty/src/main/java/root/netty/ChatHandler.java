package root.netty;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.concurrent.GlobalEventExecutor;
import root.netty.controller.SocketController;
import root.netty.dto.SocketData;
import root.netty.dto.SocketResult;
import root.util.ApplicationContextUtil;
import root.util.JsonUtils;


public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
	
	private SocketController socketController = new SocketController();
	
	// 服务端接收消息
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		// 获取客户端传输过来的消息
		String content = msg.text();
		SocketData socketData = JsonUtils.jsonToPojo(content, SocketData.class);	
		Method targetMethod = MethodMapping.mappingTo(socketData.getAction());
		targetMethod.invoke(socketController, socketData, ctx, msg);
	}
	
	// 当客户端打开服务端之后(连接)
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		NettyChannelGroup.groups.add(ctx.channel());
	}
	
	// 客户端被移除
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		NettyChannelGroup.groups.remove(ctx.channel());
	}
	
	// 工程出现异常的时候调用
	// 发生异常之后关闭channel
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.channel().close();
		NettyChannelGroup.groups.remove(ctx.channel());
	}
	
}
