package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.model.GroupAcceptChatContent;

public interface GroupAcceptChatContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupAcceptChatContent record);

    int insertSelective(GroupAcceptChatContent record);

    GroupAcceptChatContent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupAcceptChatContent record);

    int updateByPrimaryKey(GroupAcceptChatContent record);
    /**
     * 批量插入
     * @param groupAcceptChatContentList
     */
	void inertBatch(@Param("list") List<GroupAcceptChatContent> groupAcceptChatContentList);
}