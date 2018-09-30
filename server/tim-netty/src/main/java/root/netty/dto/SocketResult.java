package root.netty.dto;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import root.bean.JsonResult;
import root.bean.JsonResult.JsonResultBuilder;
import root.constant.ResultCode;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketResult {
	
	private String action;
	
	private String result;
	
	private Integer code;
	
	public static SocketResult success(String action, String result) {
		return SocketResult.builder().action(action).result(result).code(200).build();
	}
	
	public static SocketResult success() {
		return SocketResult.builder().code(200).build();
	}
	
}