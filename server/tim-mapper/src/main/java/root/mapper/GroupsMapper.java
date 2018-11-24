package root.mapper;

import org.apache.ibatis.annotations.Param;

import root.model.Groups;

public interface GroupsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);
    /**
     * 获取唯一群号(同QQ号)
     * @param qqNumber
     * @return
     */
	int countByGroupNumber(@Param("groupNumber") String groupNumber);
}