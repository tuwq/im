package root.util;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class BaseUrlUtil {
	
	private static BASE64Decoder decoder = new BASE64Decoder();
	/**
	 * base64字符串转字节数组
	 * @param baseUrl
	 * @return 字节数组
	 * @throws IOException 
	 */
	public static byte[] baseUrlToByte(String baseUrl) throws IOException {
		baseUrl = baseUrl.substring(baseUrl.indexOf("base64,")+7);
		byte[] b = decoder.decodeBuffer(baseUrl);
		for(int i=0;i<b.length;++i)  
        {  
            if(b[i]<0)  
            {//调整异常数据  
                b[i]+=256;  
            }  
        }  
		return b;
	}
	/**
	 * 是否是jpg或png文件
	 * @param baseUrl
	 * @return
	 */
	public static boolean isImageType(String baseUrl) {
		if (baseUrl.indexOf("data:image/png;") > -1|| baseUrl.indexOf("data:image/jpeg;") > -1) {
			return true;
		}
		return false;
	}
	/**
	 * base64图片是png还是jpg
	 * @param baseUrl
	 * @return 1: png, 2: jpg
	 */
	public static String getType(String baseUrl) {
		if (baseUrl.indexOf("data:image/png;") > -1) {
			return ".png";
		} 
		if (baseUrl.indexOf("data:image/jpeg;") > -1) {
			return ".jpg";
		}
		return null;
	}
	/**
	 * 将base64文件存储
	 * @param baseUrl
	 * @param imgFilePath
	 * @return
	 */
	public static boolean baseUrlToOutIntputStream(String baseUrl, String imgFilePath) {
		System.out.println("baseUrl = " + baseUrl);
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(baseUrl);
			for(int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				} 
			}
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static String InputStreamToBaseUrl(String imgFilePath) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}
	
}
