package api.users.es.users.dtos;

import api.users.es.users.entity.Address;
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
	private String birthDate;
	private Address idAddress;
}
