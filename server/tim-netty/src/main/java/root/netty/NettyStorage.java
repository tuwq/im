package root.netty;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class NettyStorage {
	
	// 用于记录和管理所有客户端的channle
	public static ChannelGroup groups = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	// 记录用户的channel
	private static ConcurrentHashMap<String,Channel> usersMap = new ConcurrentHashMap<String,Channel>();
	// 映射方法
	private static HashMap<String, Method> mappingMap = new HashMap<String, Method>();
	
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
	
	public static void addMapping(String actionName, Method targetMethod) {
		mappingMap.put(actionName, targetMethod);
	}
	
	public static Method mappingTo(String actionName) {
		return mappingMap.get(actionName);
	}
}
