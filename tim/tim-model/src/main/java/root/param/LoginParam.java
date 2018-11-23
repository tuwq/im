package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录请求的录入参数
 * @author tuwq
 */
@Setter
@Getter
public class LoginParam {

	@NotBlank(message="账户不可为空串")
	@NotNull(message="账户不可为空")
	private String loginname;
	@NotBlank(message="密码不可为空串")
	@NotNull(message="密码不可为空")
	private String password;
	@NotBlank(message="标识码不可为空串")
	@NotNull(message="标识码不可为空")
	private String appId;
}
