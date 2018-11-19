package root.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 * 修改上传头像的录入请求参数
 * @author tuwq
 *
 */
@Setter
@Getter
public class UploadAvatarBaseParam {

	@NotBlank(message="用户id不允许为空串")
	@NotNull(message="用户id不允许为空")
	private String userId;
	@NotBlank(message="头像base64Url不允许为空串")
	@NotNull(message="头像base64Url不允许为空")
	private String faceData;
	@NotNull(message="图片大小类型不能为空") // 1: 原图, 2: 修剪后
	private Integer imageSizeType;
}
