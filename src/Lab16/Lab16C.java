package Lab16;
// Association Mapping 
// 2) (One-To-Many Bi-Directional Mapping)
// Retrieving Record from requests to customers table using Annotation configuration (Join Fetch & Aggressive Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab16C {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading requests table data (SELECT QUERY on requests table and customers table using join)
			Request req = (Request)session.load(Request.class, 1);
			System.out.println("************* Request Info *************");
			System.out.println(req);
			
			// Getting customer table data using requests table 
			Customer cust = req.getCustomers();
			System.out.println("************* Customer Info *************");
			System.out.println(cust); 
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
