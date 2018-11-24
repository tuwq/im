package root.service;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.tools.doclets.internal.toolkit.util.Group;

import root.constant.ResultCode;
import root.exception.FileUploadException;
import root.mapper.GroupsMapper;
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
	/**
	 * 创建群聊
	 * 检查参数
	 * 上传群头像至七牛云
	 * 保存信息至数据库
	 * @param param
	 */
	public void create(CreateGroupParam param) {
		try {
			ValidatorUtil.check(param);
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
