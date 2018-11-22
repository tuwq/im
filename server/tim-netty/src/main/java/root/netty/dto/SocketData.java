package root.netty.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * websocket主要接收对象
 */
@Setter
@Getter
@ToString
public class SocketData{
	// 发送标识
	private String action;
	// 发送内容
	private AccepetChatContent accepetChatContent;
	// 扩展字段
	private String extendFields;
	
}
