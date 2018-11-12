package root.mapper;

import org.apache.ibatis.annotations.Param;

import root.model.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    /**
     * 手机号是否存在
     * @param telephone
     * @return
     */
	int countByTelePhone(@Param("telephone") String telephone);
	/**
	 * QQ号码是否存在
	 * @param qqNumber
	 */
	int countByQQNumber(@Param("qqNumber") String qqNumber);
}