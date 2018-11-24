package root.mapper;

import root.model.SingleChatContent;

public interface SingleChatContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleChatContent record);

    int insertSelective(SingleChatContent record);

    SingleChatContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleChatContent record);

    int updateByPrimaryKey(SingleChatContent record);
}