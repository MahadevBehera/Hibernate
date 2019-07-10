package Lab2;
// Inserting Record in customers table using Annotations configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab2A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Customer cust = new Customer("Mahadev", "mahadev@gmai.com", 900000L, "Kolkata", 23400.00);
			session.save(cust);
			//session.flush(); // Flushing Data to DB but not submitting commit to DB so no record will be inserted.
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
