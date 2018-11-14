package root.exception;

//文件上传异常
public class FileUploadException extends RuntimeException implements WebException{

	private int ResultCode;
	
	private String msg;
	
	public FileUploadException(int ResultCode,String msg) {
		this.ResultCode = ResultCode;
		this.msg = msg;
	}
	
	public int getResultCode() {
		return ResultCode;
	}
	public String getMsg() {
		return msg;
	}
	
	
	public FileUploadException() {
		super();
	}

	public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadException(String message) {
		super(message);
	}

	public FileUploadException(Throwable cause) {
		super(cause);
	}
	
}