package root.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.dto.GroupsDto;
import root.model.Groups;
import root.service.FindGroupService;

@RestController
@RequestMapping("/find/group")
public class FindGroupController {
	
	@Resource
	private FindGroupService findGroupService;
	
	@GetMapping("/list")
	public JsonResult<List<Groups>> list(@RequestParam("targetInfo") String targetInfo) {
		List<Groups> list = findGroupService.list(targetInfo);
		return JsonResult.<List<Groups>>success(list);
	}
	
	@GetMapping("/id")
	public JsonResult<GroupsDto> id(@RequestParam("groupId") String groupId,@RequestParam("meId") String meId) {
		GroupsDto groupsDto = findGroupService.id(groupId, meId);
		return JsonResult.<GroupsDto>success(groupsDto);
	}
}
