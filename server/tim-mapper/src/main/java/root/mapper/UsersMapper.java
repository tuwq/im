package root.mapper;

import org.apache.ibatis.annotations.Param;

import root.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    /**
     * 手机号是否以绑定
     * @param telephone
     * @return
     */
	int countByTelePhone(@Param("telephone") String telephone);
	/**
	 * QQ号码是否已存在
	 * @param qqNumber
	 * @return
	 */
	int countByQQNumber(@Param("qqNumber") String qqNumber);
	/**
	 * QQ号码或手机号是否存在
	 * @param loginname
	 * @return
	 */
	int countByQQNumberOrPhone(@Param("loginname") String loginname);
	/**
	 * 根据QQ号码或手机号获得用户信息
	 * @param loginname
	 * @return
	 */
	Users getByQQNumberOrPhone(@Param("loginname") String loginname);
	/**
	 * 修改原图头像
	 * @param userId
	 * @param string
	 */
	void updateBigAvatar(@Param("id") String id, @Param("faceImageBig") String faceImageBig);
	/**
	 * 修改修剪头像
	 * @param userId
	 * @param string
	 */
	void updateCutAvatar(@Param("id") String id, @Param("faceImageCut") String faceImageCut);
	/**
	 * 用户是否存在
	 * @param userId
	 * @return
	 */
	int countById(@Param("id") String id);
	/**
	 * 修改昵称
	 * @param userId
	 * @param editValue
	 */
	void updateNickname(@Param("id") String id, @Param("nickname") String nickname);
	/**
	 * 修改签名
	 * @param userId
	 * @param description
	 */
	void updateDescription(@Param("id") String id, @Param("description") String description);
}