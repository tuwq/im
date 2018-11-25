package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.model.Groups;
import root.model.Users;

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
	/**
	 * 根据群号或群名称寻找群
	 * @param targetInfo
	 * @return
	 */
	List<Groups> findByGroupNumberOrGroupName(@Param("targetInfo") String targetInfo);
	/**
	 * 群聊是否存在
	 * @param groupId
	 * @return
	 */
	int countById(@Param("id") String id);
	/**
	 * 群人数自增
	 * @param groupId
	 */
	void incrUserSum(@Param("id") String id);
}