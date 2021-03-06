package root.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import root.exception.CheckParamException;
import root.exception.FileUploadException;
import root.exceptionResult.FileUploadExceptionResult;
import root.exceptionResult.ParamExceptionResult;


@ControllerAdvice
public class ExceptionAdvice {
	
	
	// 检查参数出错的异常
	@ExceptionHandler(CheckParamException.class)
	public ResponseEntity<ParamExceptionResult> handlerParamException(CheckParamException e) {
		// TODO 记录异常日志
		return new ResponseEntity<ParamExceptionResult>(ParamExceptionResult.error(e.getMessage()),HttpStatus.OK);
	}
	
	// 文件上传时的异常
	@ExceptionHandler(FileUploadException.class)
	public ResponseEntity<FileUploadExceptionResult> handlerFileUploadException(FileUploadException e) {
		return new ResponseEntity<FileUploadExceptionResult>(FileUploadExceptionResult.builder().code(e.getResultCode()).msg(e.getMsg()).build(),HttpStatus.OK);
	}
	
	// 处理未知异常
	@ExceptionHandler(RuntimeException.class)
	public void handlerUnknownException(RuntimeException e) {
		// TODO 记录异常日志
		e.printStackTrace();
	}
	
	// 处理未知异常
	@ExceptionHandler(Exception.class)
	public void handlerUnknownException2(Exception e) {
		// TODO 记录异常日志
		e.printStackTrace();
	}
}
