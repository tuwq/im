package root.netty.enums;

public enum AcceptTypeEnums {
	
	IMAGE("image", "图片"),
	TEXT("text", "文字"),
	BYTE("byte", "字节");
	
	private String type;
	private String desc;
	
	AcceptTypeEnums(String type, String desc) {
		this.type = type;
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
