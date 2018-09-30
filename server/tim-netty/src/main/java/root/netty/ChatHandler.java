package root.netty;

import java.util.ArrayList;
import java.util.List;

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
import root.util.JsonUtils;


public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
	
	// 服务端接收消息
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		// 获取客户端传输过来的消息
		String content = msg.text();
		Channel currentChannel = ctx.channel();
		NettyStorage.put("1", currentChannel);
		NettyStorage.output();
		currentChannel.writeAndFlush(new TextWebSocketFrame(content));
	}
	
	// 当客户端打开服务端之后(连接)
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		NettyStorage.groups.add(ctx.channel());
	}
	
	// 客户端被移除
	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		NettyStorage.groups.remove(ctx.channel());
	}
	
	//工程出现异常的时候调用
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// 发生异常之后关闭channel
		cause.printStackTrace();
		ctx.channel().close();
		NettyStorage.groups.remove(ctx.channel());
	}
	
}
