package Lab11;
 // Association Mapping 
 // 1) (One-To-One Uni-Directional Mapping)
 // Inserting Record in customers table and address table and making relation one to one between Customer and Address using XML configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab11A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//Creating Customer Object and storing Data to customers table (INSERT QUERY)
			Customer cust = new Customer("Dev", "devil","dev@gmail.com",199192928L);
			session.save(cust);
			
			//Creating Address Object and storing Data to address table (INSERT QUERY)
			Address add = new Address("BTM", "Bangalore", "Karnataka");
			session.save(add);
			
			// Making One to One Connection, Associating Address to Customer (UPDATE QUERY TO customers table)
			cust.setAddress(add);
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
