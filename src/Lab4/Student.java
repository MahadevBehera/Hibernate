package Lab4;

import java.util.*;

import javax.persistence.*;

//import org.hibernate.annotations.Proxy;

@Entity
@Table(name="students")
// @Proxy(lazy = false) // For disable Lazy loading, if it is "false" then the simple type Data will be loaded aggressively along with array data 
public class Student {
	// Simple type
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sid")
	private int sid; // P.K
	@Column(name="sname")
	private String sname;
	@Column(name="dob")
	private String dob;
	@Column(name="quali")
	private String qualification;

	// Array type
	@ElementCollection
	@CollectionTable(name= "courses", joinColumns = @JoinColumn(name = "sid"))
	@OrderColumn(name= "idx") // Mandatory for Array 
	@Column(name = "cname")
//	@Proxy(lazy = false) // Not allowed(error) for Array the marking on top of class level is also work for Array type. Here not require to specify.
	private String[] courses;

	// Collection type
	@ElementCollection
	@CollectionTable(name= "emails", joinColumns = @JoinColumn(name = "sid"))
	@OrderColumn(name= "idx") // Mandatory for List
	@Column(name = "emailId")
	private List<String> emails;

	@ElementCollection
	@CollectionTable(name= "marks", joinColumns = @JoinColumn(name = "sid"))
	//@OrderColumn(name= "idx") // Not Mandatory for like Bag Tag
	@Column(name = "marks")
	private List<Integer> marks;
	
	@ElementCollection
	@CollectionTable(name= "phones", joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "phone")
	private Set<Long> phones;
	
	@ElementCollection
	@CollectionTable(name= "reference", joinColumns = @JoinColumn(name = "sid"))
	@MapKeyColumn(name= "rname")
	@Column(name = "rphone")
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
