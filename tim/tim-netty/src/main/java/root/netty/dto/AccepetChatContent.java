package root.netty.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * 内容对象
 */
@Getter
@Setter
public class AccepetChatContent {
	// 发送者Id
	private String senderId;
	// 接收者Id
	private String acceptId;
	// 消息id
	private String contentId;
	// 字符串内容
	private String content;
	// 字节内容
	private byte[] contentForByte;
	// 内容类型,图片,文字,字节
	private String contentType;
}
