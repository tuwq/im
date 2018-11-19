package root.service;

import java.util.Random;

import javax.annotation.Resource;

import org.bouncycastle.crypto.tls.UserMappingType;
import org.springframework.stereotype.Service;

import root.exception.CheckParamException;
import root.mapper.SingleRequestMapper;
import root.mapper.SingleUsersMapper;
import root.mapper.UsersMapper;
import root.model.SingleRequest;
import root.param.RequestSingParam;
import root.util.RandomUtil;
import root.util.ValidatorUtil;

@Service
public class RequestService {

	@Resource
	private UsersMapper usersMapper;
	@Resource
	private SingleRequestMapper singleRequestMapper;
	@Resource
	private SingleUsersMapper singleUsersMapper;
	
	/**
	 * 好友请求
	 * 检查请求参数
	 * 请求用户和本人是否存在
	 * 发送好友请求
	 * ！ 是否在对方接收前以发送好友请求
	 * ! 是否已经是好友
	 * ! 是否是我自己
	 * @param param
	 */
	public void single(RequestSingParam param) {
		ValidatorUtil.check(param);
		String meId = param.getMeId();
		String acceptId = param.getAcceptId();
		if (meId.equals(acceptId)) throw new CheckParamException("请勿添加本人为好友");
		int isMe = usersMapper.countById(meId);
		if (isMe == 0) throw new CheckParamException("本人不存在");
		int isAccept = usersMapper.countById(acceptId);
		if (isAccept == 0) throw new CheckParamException("目标不存在");
		int isMyFriend = singleUsersMapper.isMyFriend(meId, acceptId);
		if (isMyFriend > 0) throw new CheckParamException("对方已经是你的好友");
		int sameRequest = singleRequestMapper.isSameRequest(meId, acceptId);
		if (sameRequest > 0) throw new CheckParamException("已向对方发起好友请求,请不要重复请求");
		SingleRequest singleRequest = SingleRequest.builder()
				.sendUserId(meId).acceptUserId(acceptId).acceptStatus(0).id(RandomUtil.getUUID()).build();
		singleRequestMapper.insertSelective(singleRequest);
	}
}
