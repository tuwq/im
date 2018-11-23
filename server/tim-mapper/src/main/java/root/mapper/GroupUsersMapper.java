package root.mapper;

import root.model.GroupUsers;

public interface GroupUsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupUsers record);

    int insertSelective(GroupUsers record);

    GroupUsers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupUsers record);

    int updateByPrimaryKey(GroupUsers record);
}