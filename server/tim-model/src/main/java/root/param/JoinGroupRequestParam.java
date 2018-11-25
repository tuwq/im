package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 请求入群请求
 * @author tuwq
 */
@Data
public class JoinGroupRequestParam {

	@NotBlank(message="群聊id不可为空串")
	@NotNull(message="群聊id不可为空")
	private String groupId;
	@NotBlank(message="个人id不可为空串")
	@NotNull(message="个人id不可为空")
	private String meId;
}
