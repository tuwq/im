package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 注册验证请求录入参数
 * @author tuwq
 *
 */
@Setter
@Getter
public class ValidateParam {
	
	@NotBlank(message="手机号不允许为空串")
	@NotNull(message="手机号不允许为空")
	private String telephone;
	
	private String validateCode;
	
}
