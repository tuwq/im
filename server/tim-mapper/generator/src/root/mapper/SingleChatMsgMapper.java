package root.mapper;

import root.model.SingleChatMsg;

public interface SingleChatMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleChatMsg record);

    int insertSelective(SingleChatMsg record);

    SingleChatMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleChatMsg record);

    int updateByPrimaryKey(SingleChatMsg record);
}