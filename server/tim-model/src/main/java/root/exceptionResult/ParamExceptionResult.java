package root.exceptionResult;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import root.constant.ResultCode;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParamExceptionResult {
	// 错误码
	private int code;
	// 错误信息
	private String msg;
	
	public static ParamExceptionResult error(String msg) {
		return ParamExceptionResult.builder().msg(msg)
				.code(ResultCode.PARAM_ERROR).build();
	}
	
}
