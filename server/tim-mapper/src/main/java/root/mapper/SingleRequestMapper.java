package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.dto.RequestSingleUserDto;
import root.model.SingleRequest;

public interface SingleRequestMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleRequest record);

    int insertSelective(SingleRequest record);

    SingleRequest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleRequest record);

    int updateByPrimaryKey(SingleRequest record);
    /**
     * 是否存在同样的请求
     * accpetStatus=0,对象没有接收操作的对象
     * @param meId
     * @param acceptId
     * @return
     */
	int isSameRequest(@Param("sendUserId") String sendUserId,@Param("acceptId") String acceptId);
	/**
	 * 未处理的接收请求,以及用户信息
	 * @param userId
	 * @return
	 */
	List<RequestSingleUserDto> noOperateList(@Param("acceptId") String userId);
	/**
	 * 修改好友请求记录的状态
	 * @param meId
	 * @param sendId
	 * @param acceptStatus
	 */
	void updateAcceptStatus(@Param("acceptUserId") String meId,@Param("sendUserId") String sendId,
			@Param("acceptStatus") Integer acceptStatus);
}