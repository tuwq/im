package root.pluginService;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import root.configConstant.TimConfigProperties;
import root.constant.ResultCode;
import root.exception.FileUploadException;
import root.util.MD5Util;

@Service
public class QiNiuService {
	
	@Resource
	private TimConfigProperties timConfigProperties;
	private Configuration cfg = new Configuration(Zone.zone2());
	private UploadManager uploadManager = new UploadManager(cfg);
	
	/**
	 * 通过字节数组上传至七牛云
	 * @param file
	 * @param userId
	 */
	public String avatarForByte(byte[] uploadBytes, String fileName) {
		String key = timConfigProperties.getQiniu().getAvatarPrefix() + fileName;
		Auth auth = Auth.create(timConfigProperties.getQiniu().getAcKey(), timConfigProperties.getQiniu().getSeKey());
		long expireSeconds = 3600;
		String upToken = auth.uploadToken(timConfigProperties.getQiniu().getImgBucket(), key, expireSeconds, new StringMap().put("insertOnly",0));
		try {
		    Response response = uploadManager.put(uploadBytes, key, upToken);
		    //解析上传成功的结果
		    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		    return putRet.key;
		} catch (QiniuException ex) {
		    Response r = ex.response;
		    System.err.println(r.toString());
		    try {
		        System.err.println(r.bodyString());
		    } catch (QiniuException ex2) {
		    	throw new FileUploadException(ResultCode.FILE_UPLOAD_FAIL,"上传文件至七牛云失败");
		    }
		}
		return null;
	}
	
}
