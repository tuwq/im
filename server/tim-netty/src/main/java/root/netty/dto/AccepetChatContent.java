package root.netty.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * 聊天接收内容
 * @author tuwq
 */
@Getter
@Setter
public class AccepetChatContent {
	// 发送者Id
	private String sendId;
	// 接收者Id
	private String acceptId;
	// 字符串内容
	private String content;
	// 字节内容
	private byte[] contentForByte;
	// 内容类型,图片,文字,字节
	private String contentType;
}
