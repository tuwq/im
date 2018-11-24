package root.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class WSServerInitialzer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		ChannelPipeline pipeline = channel.pipeline();
		// websocket 基于http协议，所以要有http编解码器
		pipeline.addLast(new HttpServerCodec());
		// 对写大数据流的支持
		pipeline.addLast(new ChunkedWriteHandler());
		// 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
		// 几乎在netty中的编码，都会使用此handler
		pipeline.addLast(new HttpObjectAggregator(1024*64));
		/*----------------------以上用于支持http协议---------------------------*/
		// 增加心跳支持 ,自定义空闲状态检测
		// 针对客户端，如果一分钟内没有向服务端发送读写心跳（ALL）,则主动断开,测试时12秒
		// 如果是读空闲或者写空闲不做处理
		pipeline.addLast(new IdleStateHandler(30, 30, 60));
		pipeline.addLast(new HeartBeatHandler());
		/**
		 * websocket 服务器处理的协议，用于指定给客户端连接访问的路由:/ws
		 * 本handler会帮你处理一些繁重复杂的事
		 * 会帮你处理握手动作:handshaking(close,ping,pong) ping+pong = 心跳
		 * 对于websocket来讲，都是以frames进行传输，不同的数据类型对应frames也不同
		 */
		// 路径
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
		// 自定义的handler
		pipeline.addLast(new ChatHandler());
	}

}
