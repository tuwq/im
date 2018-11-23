package root.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UsersDto {
	
	private String id;
	
	private String qqNumber;
	
	private String nickname;
	
	private String faceImageCut;
	
	private String faceImageBig;
	
	private String description;
	
	private String telephone;
	
	private Date createTime;
	
}
