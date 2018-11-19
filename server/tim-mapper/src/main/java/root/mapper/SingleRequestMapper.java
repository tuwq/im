package root.mapper;

import org.apache.ibatis.annotations.Param;

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
}