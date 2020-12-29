package api.users.es.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="ADDRESS")
public class Address {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="STREET", nullable = false, length = 400)
	private String street;
	
	@Column(name="STATE", nullable = false, length = 100)
	private String state;
	
	@Column(name="CITY", nullable = false, length = 100)
	private String city;
	
	@Column(name="COUNTRY", nullable = false, length = 100)
	private String country;
	
	@Column(name="ZIP", nullable = false, length = 50)
	private String zip;
}
