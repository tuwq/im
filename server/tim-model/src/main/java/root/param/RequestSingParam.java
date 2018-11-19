package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 好友请求录入参数
 * @author tuwq
 *
 */
@Setter
@Getter
public class RequestSingParam {
	@NotBlank(message="个人id不可为空串")
	@NotNull(message="个人id不可为空")
	private String meId;
	@NotBlank(message="目标id不可为空串")
	@NotNull(message="目标id不可为空")
	private String acceptId;
}
