package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 注册请求录入参数
 * @author tuwq
 *
 */
@Setter
@Getter
public class RegisterParam {
	
	@NotBlank(message="手机号不允许为空串")
	@NotNull(message="手机号不允许为空")
	private String telephone;
	@NotBlank(message="昵称不允许为空串")
	@NotNull(message="昵称不允许为空")
	private String nickname;
	@NotBlank(message="密码不允许为空串")
	@NotNull(message="密码不允许位空")
	private String password;
	@NotBlank(message="密码不允许为空串")
	@NotNull(message="密码不允许位空")
	private String rePassword;
}
