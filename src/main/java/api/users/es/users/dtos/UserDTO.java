package api.users.es.users.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserDTO {
	private Long id;
	private String name;
	private String email;
}
