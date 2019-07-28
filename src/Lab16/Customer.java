package Lab16;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "cid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid; // P.K
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private long phone;

	// Connection for One Side (For One to Many relation)
	@OneToMany(mappedBy = "customers")
	//@JoinColumn(name = "cid") // If you want to set requests using customer like cust.setRequests(reqs); then F.K specification should be mentioned here and the @OneToMany should not mark with (mappedBy = "customers") 
	//@JoinColumn(name = "cid") OR @JoinColumn(name = "cid", referencedColumnName = "cid") *** This is for One-To-Many Uni-directional relation, we have to specify F.K here only for requests table ***
	private Set<Request> requests;

	public Customer() {

	}

	// we should not add the list of requests in constructor because later we can stabilized the connection by setter method
	public Customer(String firstName, String lastName, String email, long phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Set<Request> getRequests() {
		return requests;
	}
	// We should set requests by using setter method only
	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + "]";
	}

}
