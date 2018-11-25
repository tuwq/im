package root.service;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.tools.doclets.internal.toolkit.util.Group;

import root.constant.ResultCode;
import root.exception.CheckParamException;
import root.exception.FileUploadException;
import root.mapper.GroupUsersMapper;
import root.mapper.GroupsMapper;
import root.mapper.UsersMapper;
import root.model.GroupUsers;
import root.model.Groups;
import root.param.CreateGroupParam;
import root.pluginService.QiNiuService;
import root.util.Base64Util;
import root.util.RandomUtil;
import root.util.ValidatorUtil;

@Service
public class GroupService {

	
	@Resource
	private QiNiuService qiNiuService;
	@Resource
	private GroupsMapper groupsMapper;
	@Resource
	private GroupUsersMapper groupUsersMapper;
	@Resource
	private UsersMapper usersMapper;
	/**
	 * 创建群聊
	 * 检查参数
	 * 上传群头像至七牛云
	 * 保存信息至数据库
	 * 绑定群主
	 * @param param
	 */
	@Transactional
	public void create(CreateGroupParam param) {
		try {
			ValidatorUtil.check(param);
			int creatorExist = usersMapper.countById(param.getCreatorId());
			if (creatorExist == 0) throw new CheckParamException("创建者不存在");
			String base64FaceImageBig = param.getGroupFaceImageBig();
			boolean imageType = Base64Util.isImageType(base64FaceImageBig);
			if (!imageType) { throw new FileUploadException(ResultCode.FILE_UPLOAD_FAIL, "文件类型必须是jpg或png");}
			String baseType = Base64Util.getType(base64FaceImageBig);
			byte[] uploadData = Base64Util.baseUrlToByte(base64FaceImageBig);
			String groupId = RandomUtil.getUUID();
			String fileName = groupId + "_big_group" + baseType;
			Groups groups = Groups.builder().id(groupId).groupNumber(this.getGroupNumber())
				.groupFaceimageBig(fileName).groupName(param.getGroupName())
				.groupDescription(param.getGroupDescription()).usersNum(1).createTime(new Date()).build();
			groupsMapper.insertSelective(groups);
			GroupUsers groupUsers = GroupUsers.builder().id(RandomUtil.getUUID()).createTime(new Date())
					.groupId(groupId).userId(param.getCreatorId()).build();
			groupUsersMapper.insertSelective(groupUsers);
			qiNiuService.groupAvatarForByte(uploadData, fileName);
		} catch (IOException e) {
			throw new FileUploadException(ResultCode.FILE_UPLOAD_FAIL, "上传期间发送错误");
		}
	}
	
	
	/**
	 * 遍历获取唯一群号
	 * @return
	 */
	private String getGroupNumber() {
		boolean flag = true;
		String qqNumber = null;
		while(flag) {
			qqNumber = RandomUtil.getQQNumber();
			int count = groupsMapper.countByGroupNumber(qqNumber);
			if (count == 0) {flag = false;}
		}
		return qqNumber;
	}

}
