package Lab15;
import java.util.*;

// Association Mapping 
// 2) (One-To-Many Bi-Directional Mapping)
// Retrieving Record from customers to requests table using XML configuration (Select Fetch & lazy Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab15B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading customers table data (SELECT QUERY on customers table)
			Customer cust = (Customer)session.load(Customer.class, 2);
			System.out.println("************* Customer Info *************");
			System.out.println(cust);
			
			// Getting requests table data using customer (SELECT QUERY on requests table using "cid" from requests table)
			System.out.println("************* Request Info *************");
			Set<Request> reqs= cust.getRequests(); // requests table data Loaded here one time
			for (Request request : reqs) {
				System.out.println(request); 
			}
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
