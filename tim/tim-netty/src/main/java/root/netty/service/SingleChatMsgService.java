package root.netty.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import root.enums.ChatMsgStatusEnum;
import root.mapper.SingleChatMsgMapper;
import root.model.SingleChatMsg;
import root.netty.dto.AccepetChatContent;
import root.util.RandomUtil;

@Service
public class SingleChatMsgService {

	@Resource
	private SingleChatMsgMapper singleChatMsgMapper;
	
	/**
	 * 保存私聊消息
	 * @param accepetChatContent
	 * @return
	 */
	public String saveSingleChatMsg(AccepetChatContent accepetChatContent) {
		String uuid = RandomUtil.getUUID();
		SingleChatMsg singleChatMsg = SingleChatMsg.builder().id(uuid)
			.sendUserId(accepetChatContent.getSenderId())
			.acceptUserId(accepetChatContent.getAcceptId())
			.msg(accepetChatContent.getContent())
			.signFlag(ChatMsgStatusEnum.NOSIGN.getStatusCode()).createTime(new Date())
			.build();
		singleChatMsgMapper.insertSelective(singleChatMsg);
		return uuid;
	}

	/**
	 * 批量签收私聊消息
	 * @param msgIdList
	 */
	public void batchUpdateSignStatus(List<String> msgIdList) {
		singleChatMsgMapper.batchUpdateSignStatus(msgIdList, ChatMsgStatusEnum.YESSIGN.getStatusCode());
	} 
}
