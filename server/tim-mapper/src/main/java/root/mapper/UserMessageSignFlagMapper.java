package root.mapper;

import root.model.UserMessageSignFlag;

public interface UserMessageSignFlagMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserMessageSignFlag record);

    int insertSelective(UserMessageSignFlag record);

    UserMessageSignFlag selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserMessageSignFlag record);

    int updateByPrimaryKey(UserMessageSignFlag record);
}