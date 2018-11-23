package root.exceptionResult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//文件上传异常
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileUploadExceptionResult {
	// 错误状态码
	private int code;
	// 错误信息
	private String msg;
	
	public static FileUploadExceptionResult error(int code,String msg) {
		return FileUploadExceptionResult.builder().code(code).msg(msg).build();
	}
}
