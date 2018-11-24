package root.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import root.enums.ChatMsgStatusEnum;
import root.mapper.SingleChatMsgMapper;
import root.model.SingleChatMsg;

@Service
public class SingChatMsgService {
	
	@Resource
	private SingleChatMsgMapper singleChatMsgMapper;
	/**
	 * 获取未读消息
	 * @param acceptUserId
	 * @return
	 */
	public List<SingleChatMsg> getNoReadChatMsgList(String acceptUserId) {
		return singleChatMsgMapper.getChatMsgListByStatus(acceptUserId, ChatMsgStatusEnum.NOSIGN.getStatusCode());
	}

}
