package root.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.dto.RequestSingleUserDto;
import root.param.AcceptSingleRequestParam;
import root.param.SendSingleRequestParam;
import root.service.SingleRequestService;

@RestController
@RequestMapping("/request/single")
public class SingleRequestController {

	@Resource
	private SingleRequestService requestSingleService;
	
	@PostMapping("/send")
	public JsonResult<Void> send(@RequestBody SendSingleRequestParam param) {
		requestSingleService.send(param);
		return JsonResult.<Void>success();
	} 
	
	@GetMapping("/accept")
	public JsonResult<List<RequestSingleUserDto>> accept(@RequestParam("userId") String userId) {
		List<RequestSingleUserDto> list = requestSingleService.accept(userId);
		return JsonResult.<List<RequestSingleUserDto>>success(list);
	}
	
	@PostMapping("/agree")
	public JsonResult<Void> agree(@RequestBody AcceptSingleRequestParam param) {
		requestSingleService.agree(param);
		return JsonResult.<Void>success();
	}
	
	@PostMapping("/refuse")
	public JsonResult<Void> refuse(@RequestBody AcceptSingleRequestParam param) {
		requestSingleService.refuse(param);
		return JsonResult.<Void>success();
	}
}
