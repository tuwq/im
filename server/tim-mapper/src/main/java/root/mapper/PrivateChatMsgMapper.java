package root.mapper;

import root.model.PrivateChatMsg;

public interface PrivateChatMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrivateChatMsg record);

    int insertSelective(PrivateChatMsg record);

    PrivateChatMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrivateChatMsg record);

    int updateByPrimaryKey(PrivateChatMsg record);
}