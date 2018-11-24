package root.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.model.SingleChatMsg;
import root.service.SingChatMsgService;

@RestController
@RequestMapping("/chatMsg/single")
public class SingChatMsgController {

	
	@Resource
	private SingChatMsgService singChatMsgService;
	/**
	 * 获取未上线时的未签收消息
	 * @param acceptUserId
	 * @return
	 */
	@GetMapping("/getNoReadChatMsgList")
	public JsonResult<List<SingleChatMsg>> getNoReadChatMsgList(@RequestParam("acceptUserId") String acceptUserId) {
		List<SingleChatMsg> list = singChatMsgService.getNoReadChatMsgList(acceptUserId);
		return JsonResult.<List<SingleChatMsg>>success(list);
	}
}
