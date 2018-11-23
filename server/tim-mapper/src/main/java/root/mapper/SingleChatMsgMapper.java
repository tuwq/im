package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.model.SingleChatMsg;

public interface SingleChatMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleChatMsg record);

    int insertSelective(SingleChatMsg record);

    SingleChatMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleChatMsg record);

    int updateByPrimaryKey(SingleChatMsg record);
    /**
     * 批量签收私聊消息
     * @param msgIdList
     * @param integer
     */
	void batchUpdateSignStatus(@Param("msgIdList") List<String> msgIdList,@Param("signFlag") Integer integer);
}