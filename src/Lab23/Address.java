package Lab23;

import javax.persistence.Embeddable;

@Embeddable // This is only enough to store the data inside customers table, wherever the Address type data will use it will store the data to that table. Don't @Entity or @Table annotation here bcoz Address doesn't have P.K and it should not create new table so only use @Embeddable
public class Address {
	private String street;
	private String city;
	
	public Address() {
		
	}

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
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

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + "]";
	}
	
}
