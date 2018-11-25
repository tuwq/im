package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
/**
 * 创建群聊请求录入参数
 * @author tuwq
 */
@Setter
@Getter
public class CreateGroupParam {

	@NotNull(message="群头像不能为空")
	@NotBlank(message="群头像不能为空串")
	private String groupFaceImageBig;
	@NotNull(message="创建者id不能为空")
	@NotBlank(message="创建者id不能为空串")
	private String creatorId;
	@NotNull(message="群名称不能为空")
	@NotBlank(message="群名称不能为空串")
	@Length(min = 1, max = 10, message = "群名称保持在1-10之间")
	private String groupName;
	
	@Length(min = 1, max = 100, message = "群描述保持在1-100之间")
	private String groupDescription;
}
