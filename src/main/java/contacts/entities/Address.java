package contacts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
/* org.hibernate.validator.constraints - has several validating annotatians */
import org.hibernate.validator.constraints.NotBlank; 

@Entity
public class Address  extends BaseEntity {

	@Column(length = 30, nullable = false)
        @NotBlank /* means that field cant be "empty string" - "" */
	private String street;

	@Column(length = 20, nullable = false)
        @NotBlank
	private String city;

	@Column(length = 20, nullable = true)
        @NotBlank
	private String state;

	@Column(length = 10, nullable = false)
        @NotBlank
	private String zip;

	public Address() {
	}

	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
