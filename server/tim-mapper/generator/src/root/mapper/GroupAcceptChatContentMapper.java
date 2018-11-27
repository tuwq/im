package root.mapper;

import root.model.GroupAcceptChatContent;

public interface GroupAcceptChatContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupAcceptChatContent record);

    int insertSelective(GroupAcceptChatContent record);

    GroupAcceptChatContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupAcceptChatContent record);

    int updateByPrimaryKeyWithBLOBs(GroupAcceptChatContent record);

    int updateByPrimaryKey(GroupAcceptChatContent record);
}