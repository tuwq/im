package root.netty.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SocketData{
	
	private String action;
	
	private String msg;
	
	private String extendFields;
	
}
