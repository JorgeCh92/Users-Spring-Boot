package api.users.es.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.users.es.users.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
}
