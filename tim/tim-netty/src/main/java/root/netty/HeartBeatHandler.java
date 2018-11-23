package root.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		
		// 判断evt是否是IdleStateEvent（用于触发用户事件，包含 读空闲/写空闲/读写空闲 ）
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent)evt;		// 强制类型转换
			if (event.state() == IdleState.READER_IDLE) {
				System.out.println("进入读空闲...");
			} else if (event.state() == IdleState.WRITER_IDLE) {
				System.out.println("进入写空闲...");
			} else if (event.state() == IdleState.ALL_IDLE) {
				System.out.println("channel关闭前，users的数量为：" + NettyChannelGroup.groups.size());
				Channel channel = ctx.channel();
				// 关闭无用的channel，以防资源浪费
				channel.close();
				System.out.println("channel关闭后，users的数量为：" + NettyChannelGroup.groups.size());
			}
		}
	}
	
}
