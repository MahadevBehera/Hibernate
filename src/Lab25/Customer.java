package Lab25;

import javax.persistence.*;

@Entity
@Table(name = "cutomers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid; // P.K
	private String cname;
	
	@Transient // To avoid column insertion in annotation based we can use @Transient annotation on top of any Data
	private String email;
	
	// To avoid column insertion in annotation based we can use "transient" keyword as modifier to the Data
	transient private long phone;
	
	private String city;
	private double bal;
	
	public Customer() {
		
	}

	public Customer(String cname, String email, long phone, String city, double bal) {
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.bal = bal;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", city=" + city
				+ ", bal=" + bal + "]";
	}
	
}
