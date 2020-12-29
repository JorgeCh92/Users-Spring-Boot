package api.users.es.users.converters;

import api.users.es.users.dtos.UserDTO;
import api.users.es.users.entity.Address;
import api.users.es.users.entity.User;

public class UserConverter extends AbstractConverter<User, UserDTO>{
	
	@Override
	public UserDTO fromEntity(User entity) {
		return UserDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.birthDate(entity.getBirthDate())
				.idAddress(entity.getIdAddress())
				.build();
	}

	@Override
	public User fromDTO(UserDTO dto) {
		return User.builder()
				.id(dto.getId())
				.name(dto.getName())
				.email(dto.getEmail())
				.birthDate(dto.getBirthDate())
				.idAddress(dto.getIdAddress())
				.build();
	}

}
