package Lab16;
 import java.util.*;

 // Association Mapping 
 // 2) (One-To-Many Bi-Directional Mapping)
 // Inserting Record in customers table and requests table and making relation one to Many between Customer and Request using Annotation configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab16A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//Creating Customer Object and storing Data to customers table (INSERT QUERY)
			Customer cust1 = new Customer("Mahadev", "devil","dev@gmail.com",199192928L);
			session.save(cust1);
			
			//Creating Request Object and storing Data to requests table (INSERT QUERY)
			Request req1 = new Request("request1", "22/7/2019", "active");
			session.save(req1);
			
			//Creating another Request Object and storing Data to requests table (INSERT QUERY)
			Request req2 = new Request("request2", "23/7/2019", "active");
			session.save(req2);
			// Making One to Many Connection, Associating Customer to Request (UPDATE QUERY TO requests table)
			req1.setCustomers(cust1);
			req2.setCustomers(cust1);
			
	// ***************************************************************************************************************
			
			//Creating another Customer Object and storing Data to customers table (INSERT QUERY)
			Customer cust2 = new Customer("Dev", "devil","dev@gmail.com",111111L);
			session.save(cust2);
			
			//Creating Request Object and storing Data to requests table (INSERT QUERY)
			Request req3 = new Request("request3", "24/7/2019", "active");
			session.save(req3);
			
			//Creating another Request Object and storing Data to requests table (INSERT QUERY)
			Request req4 = new Request("request4", "25/7/2019", "active");
			session.save(req4);
			// Creating Set of Requests
			 Set<Request> reqs = new LinkedHashSet<>();
			 reqs.add(req3);
			 reqs.add(req4);
			// Making One to Many Connection, Associating Request to Customer (UPDATE QUERY TO requests table)
			 cust2.setRequests(reqs);
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
