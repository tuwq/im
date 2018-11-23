package root.netty;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class NettyStorage {
	
	// 记录用户的channel
	private static ConcurrentHashMap<String,Channel> usersMap = new ConcurrentHashMap<String,Channel>();
	
	public static void put(String senderId,Channel channel) {
		usersMap.put(senderId, channel);
	}
	
	public static Channel get(String senderId) {
		return usersMap.get(senderId);
	}
	
	public static void output() {
		for (HashMap.Entry<String,Channel> entry:usersMap.entrySet()) {
			System.out.println("userId:"+entry.getKey()+",channelId:"+entry.getValue().id().asLongText());
		}
	}
	
}
