package Lab17;

import java.util.*;

public class Course {
	private int cid;
	private String cname;
	private double cost;
	private int duration;
	
	// Many-To-Many 2nd relation for other side
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
