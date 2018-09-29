package root.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	private Integer id;
	
	private Integer phone;
	
	private String name;
	
	private String email;
}
