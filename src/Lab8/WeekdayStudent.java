package Lab8;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "WDSTU")
public class WeekdayStudent extends CurrentStudent {
	private String qualification;
	private String percentage;
	private int YOP;

	public WeekdayStudent() {

	}

	public WeekdayStudent(String sname, String city, String status, double totalFee, double feeBal, String timings,
			String branch, String qualification, String percentage, int yOP) {
		super(sname, city, status, totalFee, feeBal, timings, branch);
		this.qualification = qualification;
		this.percentage = percentage;
		YOP = yOP;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public int getYOP() {
		return YOP;
	}

	public void setYOP(int yOP) {
		YOP = yOP;
	}

	@Override
	public String toString() {
		return "WeekdayStudent [ " + super.toString() + ", qualification=" + qualification + ", percentage="
				+ percentage + ", YOP=" + YOP + "]";
	}
}
