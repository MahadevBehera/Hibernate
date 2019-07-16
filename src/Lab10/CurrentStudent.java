package Lab10;

import javax.persistence.*;

@Entity
@Table(name = "CurrentStudent1")
public class CurrentStudent extends Student {
	@Column(name = "feeBal")
	private double feeBal;
	@Column(name = "timing")
	private String timings;
	@Column(name = "branch")
	private String branch;

	public CurrentStudent() {
	}

	public CurrentStudent(String sname, String city, String status, double totalFee, double feeBal, String timings,
			String branch) {
		super(sname, city, status, totalFee);
		this.feeBal = feeBal;
		this.timings = timings;
		this.branch = branch;
	}

	public double getFeeBal() {
		return feeBal;
	}

	public void setFeeBal(double feeBal) {
		this.feeBal = feeBal;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "CurrentStudent [ " + super.toString() + ", feeBal=" + feeBal + ", timings=" + timings + ", branch="
				+ branch + "]";
	}

}
