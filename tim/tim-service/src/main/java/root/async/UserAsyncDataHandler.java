package root.async;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import root.configConstant.TimConfigProperties;
import root.constant.ResultCode;
import root.exception.FileUploadException;
import root.mapper.UsersMapper;
import root.pluginService.QiNiuService;
import root.util.QRCodeUtils;

@Service
public class UserAsyncDataHandler {

	@Resource
	private TimConfigProperties timConfigProperties;
	@Resource
	private QiNiuService qiNiuService;
	@Resource
	private UsersMapper usersMapper;
	
	@Async
	public void uploadQrCode(String qqNumber, String uploadQrCode, String dbQrCode) {
		String content = timConfigProperties.getUserDefault().getDefaultQrCodePrefix() + qqNumber;
		try {
			byte[] qrCodeByteArray = QRCodeUtils.getQrCodeByteArray(content);
			qiNiuService.qrCodeForByte(qrCodeByteArray, uploadQrCode);
			usersMapper.updateQrCodeByQQNumber(qqNumber, dbQrCode);
		} catch (Exception e) {
			throw new FileUploadException(ResultCode.FILE_UPLOAD_FAIL, "二维码出现生成异常");
		} 
	}
}
