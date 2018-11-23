package root.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import root.netty.NettyStorage;
import root.netty.dto.SocketResult;
import root.netty.enums.WebSocketResultContant;
import root.util.JsonUtils;

/**
 * 推送新消息
 */
@Service
public class PushNewPullDataHandler {

	/**
	 * 请求方发出好友请求
	 * 接收方重新获取新朋友请求
	 * @param acceptId
	 */
	@Async
	public void pullNewSingleRequest(String acceptId) {
		Channel acceptChannel = NettyStorage.get(acceptId);
		if (acceptChannel != null) {
			SocketResult socketResult = SocketResult.success(WebSocketResultContant.PullNewSingleRequest, null);
			acceptChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(socketResult)));
		}
	}
	/**
	 * 接收方同意后
	 * 请求方重新获取通讯录
	 * @param senderId
	 */
	@Async
	public void pullNewContact(String senderId) {
		Channel senderChannel = NettyStorage.get(senderId);
		if (senderChannel != null) {
			SocketResult socketResult = SocketResult.success(WebSocketResultContant.PullNewContact, null);
			senderChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(socketResult)));
		}
	}

}
