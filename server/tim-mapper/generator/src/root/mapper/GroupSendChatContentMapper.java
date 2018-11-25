package root.mapper;

import root.model.GroupSendChatContent;

public interface GroupSendChatContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupSendChatContent record);

    int insertSelective(GroupSendChatContent record);

    GroupSendChatContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupSendChatContent record);

    int updateByPrimaryKey(GroupSendChatContent record);
}