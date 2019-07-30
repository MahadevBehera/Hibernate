package Lab19;
// Retrieving Record from customers table using XML configuration and Updating the Record by changing some data, So version also will be increase 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab19B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = (Customer)session.load(Customer.class, 1);
			System.out.println(cust);
			cust.setCname("Ram");
			session.update(cust);
			
			Customer cust1 = new Customer("Shyam", "shyam@gmail.com", 99999999);
			cust1.setCid(2);
			session.update(cust1);
			
			tx.commit();
			session.close();
			System.out.println("Record Inserted");
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
