package Lab11;
// Association Mapping 
// 1) (One-To-One Uni-Directional Mapping)
// Retrieving Record from customers and Address table using XML configuration (Select Fetch & lazy Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab11B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading customers table data (SELECT QUERY on customers table)
			Customer cust = (Customer)session.load(Customer.class, 1);
			System.out.println(cust);
			
			// Getting address table data using customer (SELECT QUERY on address table using "addId" from customers table)
			Address add = cust.getAddress();
			System.out.println(add); // address table data Loaded here one time
			
			// Loading address table data individually 
			Address add1 = (Address)session.load(Address.class, 1);
			System.out.println(add1); // Here it will use existing Data only it will not going to load again
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
