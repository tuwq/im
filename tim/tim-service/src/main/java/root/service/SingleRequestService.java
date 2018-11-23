package root.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import root.dto.RequestSingleUserDto;
import root.enums.SingleRequestEnum;
import root.exception.CheckParamException;
import root.mapper.SingleRequestMapper;
import root.mapper.SingleUsersMapper;
import root.mapper.UsersMapper;
import root.model.SingleRequest;
import root.model.SingleUsers;
import root.param.AcceptSingleRequestParam;
import root.param.SendSingleRequestParam;
import root.util.RandomUtil;
import root.util.TimeAgoUtils;
import root.util.ValidatorUtil;

@Service
public class SingleRequestService {

	@Resource
	private UsersMapper usersMapper;
	@Resource
	private SingleRequestMapper singleRequestMapper;
	@Resource
	private SingleUsersMapper singleUsersMapper;
	
	/**
	 * 发送好友请求
	 * 检查请求参数
	 * 请求用户和本人是否存在
	 * 发送好友请求
	 * ！ 是否在对方接收前以发送好友请求
	 * ! 是否已经是好友
	 * ! 是否是我自己
	 * @param param
	 */
	public void send(SendSingleRequestParam param) {
		ValidatorUtil.check(param);
		String meId = param.getMeId();
		String acceptId = param.getAcceptId();
		if (meId.equals(acceptId)) throw new CheckParamException("请勿添加自己为好友");
		int isMe = usersMapper.countById(meId);
		if (isMe == 0) throw new CheckParamException("本人不存在");
		int isAccept = usersMapper.countById(acceptId);
		if (isAccept == 0) throw new CheckParamException("目标不存在");
		int isMyFriend = singleUsersMapper.isMyFriend(meId, acceptId);
		if (isMyFriend > 0) throw new CheckParamException("对方已经是你的好友");
		int sameRequest = singleRequestMapper.isSameRequest(meId, acceptId);
		if (sameRequest > 0) throw new CheckParamException("已向对方发起好友请求,请不要重复请求");
		SingleRequest singleRequest = SingleRequest.builder()
				.sendUserId(meId).acceptUserId(acceptId).acceptStatus(SingleRequestEnum.NONE.getAcceptStatus()).id(RandomUtil.getUUID())
				.createTime(new Date()).build();
		singleRequestMapper.insertSelective(singleRequest);
	}
	/**
	 * 该用户接收的好友请求
	 * 检查参数
	 * 用户是否存在
	 * 寻找该用户未接收操作的好友请求
	 * @param userId
	 * @return
	 */
	public List<RequestSingleUserDto> accept(String userId) {
		if(StringUtils.isBlank(userId)) throw new CheckParamException("用户id不允许为空");
		int count = usersMapper.countById(userId);
		if(count == 0) throw new CheckParamException("用户不存在");
		List<RequestSingleUserDto> list = singleRequestMapper.noOperateList(userId);
		list.stream().forEach(item -> item.setTimeAgo(TimeAgoUtils.format(item.getRequestTime())));
		return list;
	}
	
	/**
	 * 同意好友请求
	 * 双方用户是否存在
	 * 双方是否已经是好友
	 * 建立双方好友关系
	 * 修改好友请求状态
	 * @param param
	 */
	@Transactional
	public void agree(AcceptSingleRequestParam param) {
		ValidatorUtil.check(param);
		String meId = param.getMeId();
		String sendId = param.getSendUserId();
		if (meId.equals(sendId)) throw new CheckParamException("请勿添加自己为好友");
		int isMe = usersMapper.countById(meId);
		if (isMe == 0) throw new CheckParamException("本人不存在");
		int isSend = usersMapper.countById(sendId);
		if (isSend == 0) throw new CheckParamException("目标不存在");
		int isMyFriend = singleUsersMapper.isMyFriend(meId, sendId);
		if (isMyFriend > 0) throw new CheckParamException("双方已经是好友了");
		int isHeFriend = singleUsersMapper.isMyFriend(sendId, meId);
		if (isHeFriend > 0) throw new CheckParamException("双方已经是好友了");
		SingleUsers su1 = SingleUsers.builder()
				.myId(meId).myFriendId(sendId).id(RandomUtil.getUUID()).createTime(new Date()).build();
		SingleUsers su2 = SingleUsers.builder()
				.myId(sendId).myFriendId(meId).id(RandomUtil.getUUID()).createTime(new Date()).build();
		singleUsersMapper.insertSelective(su1);
		singleUsersMapper.insertSelective(su2);
		singleRequestMapper.updateAcceptStatus(meId, sendId, SingleRequestEnum.AGREE.getAcceptStatus());
	}
	
	/**
	 * 拒绝好友请求
	 * 检查参数
	 * 双方用户是否存在
	 * 修改好友请求状态
	 * @param param
	 */
	public void refuse(AcceptSingleRequestParam param) {
		ValidatorUtil.check(param);
		String meId = param.getMeId();
		String sendId = param.getSendUserId();
		if (meId.equals(sendId)) throw new CheckParamException("请勿添加本人为好友");
		int isMe = usersMapper.countById(meId);
		if (isMe == 0) throw new CheckParamException("本人不存在");
		int isSend = usersMapper.countById(sendId);
		if (isSend == 0) throw new CheckParamException("目标不存在");
		singleRequestMapper.updateAcceptStatus(meId, sendId, SingleRequestEnum.REFUSE.getAcceptStatus());
	}
}
