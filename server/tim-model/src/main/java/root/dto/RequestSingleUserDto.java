package root.dto;

import java.sql.Date;

import lombok.Data;
import root.model.Users;

@Data
public class RequestSingleUserDto {
	private String requestId;
	private String userId;
	private String qqNumber;
	private String nickname;
	private String faceImageCut;
	private String faceImageBig;
	// 未格式化请求发送的时间
	private Date requestTime;
	// 格式化请求发送的时间
	private String timeAgo;
}
