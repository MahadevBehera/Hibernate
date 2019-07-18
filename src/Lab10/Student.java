package Lab10;

import javax.persistence.*;

@Entity
@Table(name = "students1")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student {
	@Id
	@Column(name = "sid")
	private int sid;
	@Column(name = "sname")
	private String sname;
	@Column(name = "city")
	private String city;
	@Column(name = "status")
	private String status;
	@Column(name = "totalFee")
	private double totalFee;

	public Student() {
	}

	public Student(String sname, String city, String status, double totalFee) {
		this.sname = sname;
		this.city = city;
		this.status = status;
		this.totalFee = totalFee;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", city=" + city + ", status=" + status + ", totalFee="
				+ totalFee + "]";
	}

}