package root.mapper;

import root.model.GroupChatMsg;

public interface GroupChatMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupChatMsg record);

    int insertSelective(GroupChatMsg record);

    GroupChatMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupChatMsg record);

    int updateByPrimaryKey(GroupChatMsg record);
}