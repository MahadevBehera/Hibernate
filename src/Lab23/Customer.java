package Lab23;


import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cid")
	private int cid; // P.K
	@Column(name = "cname")
	private String cname;
	
	@Embedded
	@AttributeOverrides( value = {
			@AttributeOverride(name = "street", column = @Column(name= "mystreet")),
			@AttributeOverride(name = "city", column = @Column(name= "mycity"))
	} ) // These all annotations are optional, not mandatory bcoz only @Embeddable is enough to configure which is mention on top of Address class. If we want to give some different column name to those data then only we should use otherwise it will consider the column name as variable name of Address class
	private Address address;
	
	public Customer() {
		
	}

	public Customer(String cname, Address address) {
		this.cname = cname;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}
	
}
