package Lab14;
// Association Mapping 
// 1) (One-To-One Bi-Directional Mapping)
// Retrieving Record from customers to address table using Annotation configuration(Select Fetch & Aggressive Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab14B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading customers table data (2 times SELECT QUERY on customers table and joined address table)
			Customer cust = (Customer)session.load(Customer.class, 1);
			System.out.println(cust);
			
			// Getting address table data using customer 
			Address add = cust.getAddress();
			System.out.println(add);
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
