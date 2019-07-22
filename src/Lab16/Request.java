package Lab16;

import javax.persistence.*;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@Column(name = "reqId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reqId;
	@Column(name = "description")
	private String description;
	@Column(name = "reqDate")
	private String reqDate;
	@Column(name = "status")
	private String status;
	
	// Connection for Other Side (which is One to One relation)
	@ManyToOne
	@JoinColumn(name = "cid") // *** This is for One-To-Many Bi-directional relation, we have to specify F.K here only inside requests table ***
	private Customer customers;
	
	public Request() {
		
	}

	public Request(String description, String reqDate, String status) {
		this.description = description;
		this.reqDate = reqDate;
		this.status = status;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Request [reqId=" + reqId + ", description=" + description + ", reqDate=" + reqDate + ", status="
				+ status + "]";
	}
	
	
}
