package Lab22;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cid")
	private int cid; // P.K
	@Column(name = "cname")
	private String cname;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private long phone;
	
	// For timestamp column (Hibernate will provide the value for this column automatically using Timestamp Mapping)
	@Version  // This version annotation also required otherwise it will not insert data for this column, the data will be still NULL 
	@Temporal(TemporalType.TIMESTAMP) // This is for Timestamp
	private Date tstamp;
	
	public Customer() {
		
	}

	public Customer(String cname, String email, long phone) {
		this.cname = cname;
		this.email = email;
		this.phone = phone;
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

	public Date getTstamp() {
		return tstamp;
	}

	public void setTstamp(Date tstamp) {
		this.tstamp = tstamp;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", tstamp="
				+ tstamp + "]";
	}

	
	
}
