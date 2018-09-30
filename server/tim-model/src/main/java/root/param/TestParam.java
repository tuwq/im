package root.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TestParam {
	
	@NotBlank(message="登录账户不能为空")
	private String loginname; 
	@NotBlank(message="密码不能为空")
	private String password;
}
