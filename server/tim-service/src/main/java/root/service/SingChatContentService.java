package root.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import root.enums.ChatMsgStatusEnum;
import root.mapper.SingleChatContentMapper;
import root.model.SingleChatContent;

@Service
public class SingChatContentService {
	
	@Resource
	private SingleChatContentMapper singleChatContentMapper;
	/**
	 * 获取未读消息
	 * @param acceptUserId
	 * @return
	 */
	public List<SingleChatContent> getNoReadChatMsgList(String acceptUserId) {
		return singleChatContentMapper.getChatMsgListByStatus(acceptUserId, ChatMsgStatusEnum.NOSIGN.getStatusCode());
	}

}
