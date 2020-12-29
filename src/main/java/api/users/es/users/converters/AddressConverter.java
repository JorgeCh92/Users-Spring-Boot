package api.users.es.users.converters;

import api.users.es.users.dtos.AddressDTO;
import api.users.es.users.entity.Address;

public class AddressConverter  extends AbstractConverter<Address, AddressDTO>{
	@Override
	public AddressDTO fromEntity(Address entity) {
		return AddressDTO.builder()
				.id(entity.getId())
				.street(entity.getStreet())
				.state(entity.getState())
				.city(entity.getCity())
				.country(entity.getCountry())
				.zip(entity.getZip())
				.build();
	}

	@Override
	public Address fromDTO(AddressDTO dto) {
		return Address.builder()
				.id(dto.getId())
				.street(dto.getStreet())
				.state(dto.getState())
				.city(dto.getCity())
				.country(dto.getCountry())
				.zip(dto.getZip())
				.build();
	}
}
