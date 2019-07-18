package Lab12;
// Association Mapping 
// 1) (One-To-One Uni-Directional Mapping)
// Retrieving Record from customers and Address table using Annotation configuration(Join Fetch & Aggressive Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab12B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading customers table data (SELECT QUERY on customers table and joined address table)
			Customer cust = (Customer)session.load(Customer.class, 1);
			System.out.println(cust);
			
			// Getting address table data using customer 
			Address add = cust.getAddress();
			System.out.println(add);
			
			// Loading address table data individually 
			Address add1 = (Address)session.load(Address.class, 1);
			System.out.println(add1);
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
