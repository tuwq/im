package root.enums;

public enum SingleRequestEnum {
	NONE(0, "未被接收操作"),
	AGREE(1, "同意"),
	REFUSE(2, "拒绝"),
	IGNORE(3, "忽略");
	
	private Integer acceptStatus;
	private String description;
	
	SingleRequestEnum(Integer acceptStatus,String description) {
		this.acceptStatus = acceptStatus;
		this.description = description;
	}

	public Integer getAcceptStatus() {
		return acceptStatus;
	}
	public void setAcceptStatus(Integer acceptStatus) {
		this.acceptStatus = acceptStatus;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
