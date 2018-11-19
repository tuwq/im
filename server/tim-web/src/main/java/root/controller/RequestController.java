package root.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.param.RequestSingParam;
import root.service.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {

	@Resource
	private RequestService requestService;
	
	@PostMapping("/single")
	public JsonResult<Void> single(@RequestBody RequestSingParam param) {
		requestService.single(param);
		return JsonResult.<Void>success();
	} 
}
