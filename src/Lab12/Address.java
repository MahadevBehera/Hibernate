package Lab12;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@Column(name = "aid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	@Column(name = "street")
	private String street;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;

	public Address() {

	}

	public Address(String street, String city, String state) {
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
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

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}

}
