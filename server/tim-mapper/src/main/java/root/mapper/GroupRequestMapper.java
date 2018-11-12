package root.mapper;

import root.model.GroupRequest;

public interface GroupRequestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupRequest record);

    int insertSelective(GroupRequest record);

    GroupRequest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupRequest record);

    int updateByPrimaryKey(GroupRequest record);
}