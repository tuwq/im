package root.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.dto.UsersDto;
import root.service.FindSingleService;

@RestController
@RequestMapping("/findSingle")
public class FindSingleController {

	@Resource
	private FindSingleService findSingleService;
	
	@GetMapping("/list")
	public JsonResult<List<UsersDto>> list(@RequestParam("targetInfo") String targetInfo) {
		List<UsersDto> list = findSingleService.list(targetInfo);
		return JsonResult.<List<UsersDto>>success(list);
	}
	
	@GetMapping("/detail")
	public JsonResult<UsersDto> detail(@RequestParam("userId") String userId) {
		UsersDto usersDto = findSingleService.detail(userId);
		return JsonResult.<UsersDto>success(usersDto);
	}
}
