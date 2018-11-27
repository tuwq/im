package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.model.SingleChatContent;

public interface SingleChatContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleChatContent record);

    int insertSelective(SingleChatContent record);

    SingleChatContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleChatContent record);

    int updateByPrimaryKeyWithBLOBs(SingleChatContent record);

    int updateByPrimaryKey(SingleChatContent record);
    
    /**
     * 批量签收私聊消息
     * @param msgIdList
     * @param integer
     */
	void batchUpdateSignStatus(@Param("msgIdList") List<String> msgIdList,@Param("signFlag") Integer signFlag);
	/**
	 * 获取指定状态用户的签收消息
	 * @param acceptUserId
	 * @param statusCode
	 * @return
	 */
	List<SingleChatContent> getChatMsgListByStatus(@Param("acceptUserId") String acceptUserId,@Param("statusCode") Integer statusCode);
}