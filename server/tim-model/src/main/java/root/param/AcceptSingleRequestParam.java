package root.param;

import lombok.Getter;
import lombok.Setter;

/**
 * 接收好友请求的参数
 * @author tuwq
 *
 */
@Setter
@Getter
public class AcceptSingleRequestParam {

	private String meId;
	
	private String sendUserId;
	
}
