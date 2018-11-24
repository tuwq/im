package root.mapper;

import root.model.GroupChatContent;

public interface GroupChatContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupChatContent record);

    int insertSelective(GroupChatContent record);

    GroupChatContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupChatContent record);

    int updateByPrimaryKey(GroupChatContent record);
}