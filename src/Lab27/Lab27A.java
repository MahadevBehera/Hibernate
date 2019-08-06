package Lab27;
 // Inserting Record in customers table using Annotation configuration and Its a example Immutable Objects means the data of the Table we can't modify after insertion once
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab27A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = new Customer("Dev", "dev@gmail.com", 999999, "Bangalore", 20000.00);
			session.save(cust); 
			System.out.println("Inserted");
			tx.commit(); // Transaction closed and Session cache deleted but, now Customer object having P.K value bcoz DB engine returned the ID value 
			System.out.println(cust); // We can get ID value here (P.K = 1)
			
			tx = session.beginTransaction(); // Again Transaction started
			System.out.println("Trying to Update name");
			cust.setCname("Mahadev"); // in Java Object we changed the cname value
			session.update(cust); // Here we are trying to update the DB data, updating cname which is available for P.K = 1 in customers table, but it will not Update bcoz its a Immutable. 
			
			tx.commit();
			session.close();
			System.out.println("Record Inserted");
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
