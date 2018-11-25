package root.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.param.JoinGroupRequestParam;
import root.service.GroupRequestService;

@RestController
@RequestMapping("/request/group")
public class GroupRequestController {

	@Resource
	private GroupRequestService groupRequestService;
	
	@PostMapping("/join")
	public JsonResult<Void> join(@RequestBody JoinGroupRequestParam param) {
		groupRequestService.join(param);
		return JsonResult.<Void>success();
	}
}
