package Lab3;

import java.util.*;

public class Student {
	// Simple type
	private int sid; // P.K
	private String sname;
	private String dob;
	private String qualification;

	// Array type
	private String[] courses;

	// Collection type
	private List<String> emails;
	private List<Integer> marks;
	private Set<Long> phones;
	private Map<String, Long> refs;

	public Student() {
	} // D.C

	public Student(String sname, String dob, String qualification, String[] courses, List<String> emails,
			List<Integer> marks, Set<Long> phones, Map<String, Long> refs) { // without ID/P.K (sid)
		super();
		this.sname = sname;
		this.dob = dob;
		this.qualification = qualification;
		this.courses = courses;
		this.emails = emails;
		this.marks = marks;
		this.phones = phones;
		this.refs = refs;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

	public Set<Long> getPhones() {
		return phones;
	}

	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}

	public Map<String, Long> getRefs() {
		return refs;
	}

	public void setRefs(Map<String, Long> refs) {
		this.refs = refs;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", dob=" + dob + ", qualification=" + qualification + "]";
	}

	// @Override
	// public String toString() {
	// return "Student [sid=" + sid + ", sname=" + sname + ", dob=" + dob + ",
	// qualification=" + qualification
	// + ", courses=" + Arrays.toString(courses) + ", emails=" + emails + ", marks="
	// + marks + ", phones="
	// + phones + ", refs=" + refs + "]";
	// }

}
