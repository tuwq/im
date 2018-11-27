package root.dto;

import lombok.Data;
import root.model.Groups;

/**
 * 聊天记录
 * @author tuwq
 */
@Data
public class GroupChatContentDto {

	private String contentId;
	
	private UsersDto sender;
	
	private String groupId;
	
	private String content;
	
	private String contentType;
}
