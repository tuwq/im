package root.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.dto.GroupChatContentDto;
import root.netty.service.GroupChatMsgService;

@RestController
@RequestMapping("/chatMsg/group")
public class GroupChatMsgController {
	
	@Resource
	private GroupChatMsgService groupChatMsgService;
	
	@GetMapping("/getNoReadChatMsgList")
	public JsonResult<List<GroupChatContentDto>> getNoReadChatMsgList(@RequestParam("acceptUserId") String acceptUserId) {
		List<GroupChatContentDto> list = groupChatMsgService.getNoReadChatMsgList(acceptUserId);
		return JsonResult.<List<GroupChatContentDto>>success(list);
	}
}
