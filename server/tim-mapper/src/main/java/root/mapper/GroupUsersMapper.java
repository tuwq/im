package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.model.GroupUsers;
import root.model.Groups;
import root.model.Users;

public interface GroupUsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupUsers record);

    int insertSelective(GroupUsers record);

    GroupUsers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupUsers record);

    int updateByPrimaryKey(GroupUsers record);
    /**
     * 寻找部分群成员的信息
     * @param groupId
     * @return
     */
	List<Users> findGroupMemberInfo(@Param("groupId") String groupId);
	/**
	 * 是否已经加入该群
	 * @param meId 
	 * @param meId
	 * @return
	 */
	int isJoined(@Param("groupId") String groupId,@Param("userId") String meId);
	/**
	 * 所有群成员的信息
	 * @param groupId
	 * @return
	 */
	List<Users> memberListByGroupId(@Param("groupId") String groupId);
	/**
	 * 用户已加入的群信息
	 * @param userId
	 * @return
	 */
	List<Groups> groupListByUserId(@Param("userId") String userId);
}