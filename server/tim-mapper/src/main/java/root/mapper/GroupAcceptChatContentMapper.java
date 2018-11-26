package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import root.dto.GroupChatContentDto;
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
	/**
	 * 批量签收群聊接收消息
	 * @param msgIdList
	 * @param statusCode
	 */
	void batchUpdateSignStatus(@Param("msgIdList") List<String> msgIdList,@Param("signFlag") Integer signFlag);
	/**
	 * 获得未读的群聊消息
	 * @param acceptUserId
	 * @param integer 
	 * @return
	 */
	List<GroupChatContentDto> getNoReadListByAcceptUserId(@Param("acceptUserId") String acceptUserId,@Param("signFlag") Integer signFlag);
}