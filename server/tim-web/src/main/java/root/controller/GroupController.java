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
import root.dto.UsersDto;
import root.model.Groups;
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
	
	@GetMapping("/memberList")
	public JsonResult<List<UsersDto>> memberList(@RequestParam("groupId") String groupId) {
		List<UsersDto> list = groupService.memberList(groupId);
		return JsonResult.<List<UsersDto>>success(list);
	}
	
	@GetMapping("/listByUserId")
	public JsonResult<List<Groups>> listByUserId(@RequestParam("userId") String userId) {
		List<Groups> list = groupService.listByUserId(userId);
		return JsonResult.<List<Groups>>success(list);
	}
}
