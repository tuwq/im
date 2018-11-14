package root.service;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.bouncycastle.crypto.tls.UserMappingType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import root.constant.ResultCode;
import root.dto.LoginDto;
import root.exception.FileUploadException;
import root.mapper.UsersMapper;
import root.model.Users;
import root.param.UploadAvatarBaseParam;
import root.pluginService.QiNiuService;
import root.util.BaseUrlUtil;
import root.util.DtoUtil;
import root.util.ValidatorUtil;

@Service
public class UserService {

	@Resource
	private QiNiuService qiNiuService;
	@Resource
	private UsersMapper usersMapper;
	
	/**
	 * 检查base64URL文件类型
	 * 将base64URL头像上传至七牛云
	 * 根据图片大小类型修改用户数据
	 * 返回新地址
	 * @param param
	 * @return
	 */
	public String uploadAvatarForBase(UploadAvatarBaseParam param) {
		ValidatorUtil.check(param);
		try {
			boolean imageType = BaseUrlUtil.isImageType(param.getFaceData());
			if (!imageType) { throw new FileUploadException(ResultCode.FILE_UPLOAD_FAIL, "文件类型必须是jpg或png");}
			String baseType = BaseUrlUtil.getType(param.getFaceData());
			byte[] uploadData = BaseUrlUtil.baseUrlToByte(param.getFaceData());
			String fileName;
			if (param.getImageSizeType() == 1) {
				fileName =  param.getUserId() + "_big" + baseType;
			} else if(param.getImageSizeType() == 2) {
				fileName =  param.getUserId() + "_cut" + baseType;
			} else {throw new FileUploadException(ResultCode.FILE_UPLOAD_FAIL, "未知的文件大小类型");}
			qiNiuService.avatarForByte(uploadData, fileName);
			if (param.getImageSizeType() == 1) {
				usersMapper.updateBigAvatar(param.getUserId(),fileName+"?v="+new Date().getTime());
			} else if(param.getImageSizeType() == 2) {
				usersMapper.updateCutAvatar(param.getUserId(),fileName+"?v="+new Date().getTime());
			}
			return fileName + "?v="+new Date().getTime();
		} catch (IOException e) {
			throw new FileUploadException(ResultCode.FILE_UPLOAD_FAIL, "上传期间发送错误");
		}
	}

}
