package root.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.model.SingleChatContent;
import root.service.SingChatContentService;

@RestController
@RequestMapping("/chatMsg/single")
public class SingChatMsgController {

	
	@Resource
	private SingChatContentService singChatContentService;
	/**
	 * 获取未上线时的未签收消息
	 * @param acceptUserId
	 * @return
	 */
	@GetMapping("/getNoReadChatMsgList")
	public JsonResult<List<SingleChatContent>> getNoReadChatMsgList(@RequestParam("acceptUserId") String acceptUserId) {
		List<SingleChatContent> list = singChatContentService.getNoReadChatMsgList(acceptUserId);
		return JsonResult.<List<SingleChatContent>>success(list);
	}
}
