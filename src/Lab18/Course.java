package Lab18;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "MyCourses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cid")
	private int cid;
	@Column(name = "cname")
	private String cname;
	@Column(name = "cost")
	private double cost;
	@Column(name = "duration")
	private int duration;
	
	// Many-To-Many 2nd relation for other side
	@ManyToMany(mappedBy = "courses")
	//@JoinTable(name = "stu_cou", joinColumns = @JoinColumn(name = "cid", referencedColumnName = "cid"), // If you want to set Students using Courses like c3.setStudents(students1); then F.K specification should be mentioned here and the @ManyToMany should not mark with (mappedBy = "courses")
	//							 inverseJoinColumns =@JoinColumn(name = "sid", referencedColumnName = "sid")) 
	private Set<Student> students;
	
	public Course() {
		
	}
	// Don't include cid(P.K) and students here, Hibernate will provide P.K value and students we should set through setter method
	public Course(String cname, double cost, int duration) {
		this.cname = cname;
		this.cost = cost;
		this.duration = duration;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", cost=" + cost + ", duration=" + duration + "]";
	}
	
}
