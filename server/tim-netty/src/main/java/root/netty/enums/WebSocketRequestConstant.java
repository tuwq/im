package root.netty.enums;

/**
 * websocket动作常量
 *
 */
public class WebSocketRequestConstant {
	// 打开连接
	public final static String OpenWebsocket = "OpenWebsocket";
	// 心跳连接
	public final static String KeepALive = "KeepALive";
	// 发送私聊消息
	public final static String SingleChatSendMsg = "SingleChatSendMsg";
	// 发送私聊图片
	public final static String SingleChatSendImage = "SingleChatSendImage";
	// 签收私聊消息
	public final static String SingleSigningMsg = "SingleSigningMsg";
	// 发送群聊消息
	public final static String GroupChatSendMsg = "GroupChatSendMsg";
	// 发送群聊图片
	public final static String GroupChatSendImage = "GroupChatSendImage";
	// 签收群聊消息
	public final static String GroupSigningMsg = "GroupSigningMsg";
}
