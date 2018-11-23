package root.mapper;

import root.model.SingleRequest;

public interface SingleRequestMapper {
    int deleteByPrimaryKey(String id);

    int insert(SingleRequest record);

    int insertSelective(SingleRequest record);

    SingleRequest selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SingleRequest record);

    int updateByPrimaryKey(SingleRequest record);
}