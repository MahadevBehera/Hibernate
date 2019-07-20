package Lab13;
 // Association Mapping 
 // 1) (One-To-One Bi-Directional Mapping)
 // Inserting Record in customers table and address table and making relation one to one between Customer and Address using XML configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab13A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			//Creating Customer Object and storing Data to customers table (INSERT QUERY)
			Customer cust = new Customer("Mahadev", "devil","dev@gmail.com",199192928L);
			session.save(cust);
			
			//Creating Address Object and storing Data to address table (INSERT QUERY)
			Address add = new Address("Angus", "Kolkata", "WestBengal");
			session.save(add);
			
			// Making One to One Connection, Associating Address to Customer (UPDATE QUERY TO customers table)
			cust.setAddress(add);
			// add.setCustomer(cust); // it will not work, it is not going to update the table and not associate address table with customer
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
