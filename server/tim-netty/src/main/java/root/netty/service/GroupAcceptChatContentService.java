package root.netty.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import root.enums.ChatMsgStatusEnum;
import root.mapper.GroupAcceptChatContentMapper;

@Service
public class GroupAcceptChatContentService {
	
	@Resource
	private GroupAcceptChatContentMapper groupAcceptChatContentMapper;
	
	/**
	 * 批量签收群聊接收消息
	 * @param msgIdList
	 */
	public void batchUpdateSignStatus(List<String> msgIdList) {
		groupAcceptChatContentMapper.batchUpdateSignStatus(msgIdList, ChatMsgStatusEnum.YESSIGN.getStatusCode());
	}

}
