package root.mapper;

import root.model.UserMessageSignFlag;

public interface UserMessageSignFlagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserMessageSignFlag record);

    int insertSelective(UserMessageSignFlag record);

    UserMessageSignFlag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMessageSignFlag record);

    int updateByPrimaryKey(UserMessageSignFlag record);
}