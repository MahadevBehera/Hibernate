package Lab17;

import java.util.*;

public class Student {
	private int sid;
	private String sname;
	private String email;
	private long phone;
	
	// Many-To-Many 1st relation for one side
	Set<Course> courses;
	
	public Student() {
		
	}
	
	// Don't include sid(P.K) and courses here, Hibernate will provide P.K value and courses we should set through setter method
	public Student(String sname, String email, long phone) {
		this.sname = sname;
		this.email = email;
		this.phone = phone;
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

	public Set<Course> getCourses() {
		return courses;
	}
	
	// courses we should set through setter method 
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
