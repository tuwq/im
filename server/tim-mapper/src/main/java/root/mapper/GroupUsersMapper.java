package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.model.GroupUsers;
import root.model.Users;

public interface GroupUsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupUsers record);

    int insertSelective(GroupUsers record);

    GroupUsers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupUsers record);

    int updateByPrimaryKey(GroupUsers record);
    /**
     * 寻找群友们的信息
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
}