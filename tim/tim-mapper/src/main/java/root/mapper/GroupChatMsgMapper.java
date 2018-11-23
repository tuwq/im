package root.mapper;

import root.model.GroupChatMsg;

public interface GroupChatMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupChatMsg record);

    int insertSelective(GroupChatMsg record);

    GroupChatMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupChatMsg record);

    int updateByPrimaryKey(GroupChatMsg record);
}