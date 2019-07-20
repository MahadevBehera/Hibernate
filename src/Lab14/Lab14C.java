package Lab14;
// Association Mapping 
// 1) (One-To-One Bi-Directional Mapping)
// Retrieving Record from address to customers table using Annotation configuration (Join Fetch & Aggressive Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab14C {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading address table data (SELECT QUERY on address table and customer table using Join Fetch)
			Address add = (Address)session.load(Address.class, 2);
			System.out.println(add);
			
			// Getting customer table data using address table
			Customer cust = add.getCustomer();
			System.out.println(cust); 
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
