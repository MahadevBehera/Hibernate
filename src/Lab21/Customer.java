package Lab21;

import java.sql.Timestamp;

public class Customer {
	private int cid; // P.K
	private String cname;
	private String email;
	private long phone;
	
	// For timestamp column (Hibernate will provide the value for this column automatically using Timestamp Mapping)
	private Timestamp tstamp;
	
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

	public Timestamp getTstamp() {
		return tstamp;
	}

	public void setTstamp(Timestamp tstamp) {
		this.tstamp = tstamp;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", tstamp="
				+ tstamp + "]";
	}

	
	
}
