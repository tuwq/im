package root.dto;

import java.util.List;

import lombok.Data;
import root.model.Groups;

@Data
public class GroupsDto extends Groups {

	private List<UsersDto> memberList;
	
	private boolean joined = false;
}
