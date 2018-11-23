package root.exception;

import lombok.Data;

// 检查参数异常
@Data
public class CheckParamException extends RuntimeException implements WebException{

	private static final long serialVersionUID = 1L;

	public CheckParamException() {
		super();
	}
	public CheckParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public CheckParamException(String message, Throwable cause) {
		super(message, cause);
	}
	public CheckParamException(String message) {
		super(message);
	}
	public CheckParamException(Throwable cause) {
		super(cause);
	}
	
}
