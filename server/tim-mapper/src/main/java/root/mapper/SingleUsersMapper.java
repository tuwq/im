package root.mapper;

import org.apache.ibatis.annotations.Param;

import root.model.SingleUsers;

public interface SingleUsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleUsers record);

    int insertSelective(SingleUsers record);

    SingleUsers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleUsers record);

    int updateByPrimaryKey(SingleUsers record);
    /**
     * 对方是否已经是我的好友
     * @param meId
     * @param acceptId
     * @return
     */
	int isMyFriend(@Param("myId") String meId,@Param("friendId") String acceptId);
}