package root.mapper;

import root.model.PrivateChatMsg;

public interface PrivateChatMsgMapper {
    int deleteByPrimaryKey(String id);

    int insert(PrivateChatMsg record);

    int insertSelective(PrivateChatMsg record);

    PrivateChatMsg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PrivateChatMsg record);

    int updateByPrimaryKey(PrivateChatMsg record);
}