package root.bean;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import root.constant.ResultCode;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
	
	// 额外消息
	private String msg;
	// 返回码
	private int code;
	// 是否成功
	private boolean flag;
	// 返回主体
	private T result;
	
	public static <T> JsonResult<T> success(T result) {
		return JsonResult.<T>builder().result(result).flag(true).code(200).build();
	}
	
	public static <T> JsonResult<T> success(T result, String msg) {
		return JsonResult.<T>builder().result(result).flag(true).code(200).msg(msg).build();
	}
	
	public static JsonResult<Void> success() {
		return JsonResult.<Void>builder().flag(true).code(200).build();
	}
	
	public static JsonResult<Void> error(int code, String msg) {
		return JsonResult.<Void>builder().result(null).code(code).msg(msg).build();
	}
	
	public static JsonResult<Void> error(String msg) {
		return JsonResult.<Void>builder().msg(msg).code(ResultCode.REQUEST_ERROR).build();
	}
	
	public static JsonResult<Void> error(int code) {
		return JsonResult.<Void>builder().result(null).code(code).build();
	}
	
	public Map<String, Object> toMap() {
		HashMap<String, Object> map = Maps.newHashMap();
		map.put("flag", flag);
		map.put("msg", msg);
		map.put("result", result);
		return map;
	}
}
