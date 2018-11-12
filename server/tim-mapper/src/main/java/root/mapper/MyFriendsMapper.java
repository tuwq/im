package root.mapper;

import root.model.MyFriends;

public interface MyFriendsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyFriends record);

    int insertSelective(MyFriends record);

    MyFriends selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyFriends record);

    int updateByPrimaryKey(MyFriends record);
}