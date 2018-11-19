package root.mapper;

import root.model.SingleUsers;

public interface SingleUsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleUsers record);

    int insertSelective(SingleUsers record);

    SingleUsers selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleUsers record);

    int updateByPrimaryKey(SingleUsers record);
}