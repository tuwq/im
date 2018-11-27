package root.netty.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import root.enums.ChatMsgStatusEnum;
import root.mapper.SingleChatContentMapper;
import root.model.SingleChatContent;
import root.netty.dto.AccepetChatContent;
import root.netty.enums.AcceptTypeEnums;
import root.util.RandomUtil;

@Service
public class SingleChatMsgService {

	@Resource
	private SingleChatContentMapper singleChatContentMapper;
	
	/**
	 * 保存私聊文字消息
	 * @param accepetChatContent
	 * @return
	 */
	public String saveSingleChatMsg(AccepetChatContent accepetChatContent) {
		String uuid = RandomUtil.getUUID();
		SingleChatContent singleChatContent = SingleChatContent.builder().id(uuid)
			.sendUserId(accepetChatContent.getSenderId())
			.acceptUserId(accepetChatContent.getAcceptId())
			.content(accepetChatContent.getContent())
			.contentType(AcceptTypeEnums.TEXT.getType())
			.signFlag(ChatMsgStatusEnum.NOSIGN.getStatusCode()).createTime(new Date())
			.build();
		singleChatContentMapper.insertSelective(singleChatContent);
		return uuid;
	}
	
	/**
	 * 保存私聊图片消息
	 * @param accepetChatContent
	 * @return
	 */
	public String saveSingleChatImage(AccepetChatContent accepetChatContent) {
		String uuid = RandomUtil.getUUID();
		SingleChatContent singleChatContent = SingleChatContent.builder().id(uuid)
			.sendUserId(accepetChatContent.getSenderId())
			.acceptUserId(accepetChatContent.getAcceptId())
			.content(accepetChatContent.getContent())
			.contentType(AcceptTypeEnums.IMAGE.getType())
			.signFlag(ChatMsgStatusEnum.NOSIGN.getStatusCode()).createTime(new Date())
			.build();
		singleChatContentMapper.insertSelective(singleChatContent);
		return uuid;
	}

	/**
	 * 批量签收私聊消息
	 * @param msgIdList
	 */
	public void batchUpdateSignStatus(List<String> msgIdList) {
		singleChatContentMapper.batchUpdateSignStatus(msgIdList, ChatMsgStatusEnum.YESSIGN.getStatusCode());
	} 
}
