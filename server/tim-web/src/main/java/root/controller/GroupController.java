package root.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.param.CreateGroupParam;
import root.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Resource
	private GroupService groupService;
	
	@PostMapping("/create")
	public JsonResult<Void> create(@RequestBody CreateGroupParam param) {
		groupService.create(param);
		return JsonResult.<Void>success();
	}
}
