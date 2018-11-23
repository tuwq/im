package root.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class NettyChannelGroup {

	// 用于记录和管理所有客户端的channle
	public static ChannelGroup groups = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
