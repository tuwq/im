package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 编辑个人信息请求录入参数
 * @author tuwq
 */
@Setter
@Getter
public class EditMeInfoParam {
	@NotNull(message="用户id不能为空")
	@NotBlank(message="用户id不能为空串")
	private String userId;
	@NotNull(message="修改类型不能为空")
	@NotBlank(message="修改类型不能为空串")
	// 修改信息的类型 1:昵称 2: 签名
	private Integer editType;
	@NotNull(message="修改类型不能为空")
	private String editValue;
}
