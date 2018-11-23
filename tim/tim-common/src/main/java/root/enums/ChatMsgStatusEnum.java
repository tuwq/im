package root.enums;

public enum ChatMsgStatusEnum {
	NOSIGN(0, "未签收"),
	YESSIGN(1, "已签收");
	
	private Integer statusCode;
	private String desc;
	
	ChatMsgStatusEnum(Integer statusCode, String desc) {
		this.statusCode = statusCode;
		this.desc = desc;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
