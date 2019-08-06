package Lab24;
 // Inserting Record in customers table using XML configuration and Its a example Of Avoiding column Insertion into table
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab24A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = new Customer("Dev", "dev@gmail.com", 999999, "Bangalore", 20000.00);
			session.save(cust); // email and phone data will not store to table
			
			tx.commit();
			session.close();
			System.out.println("Record Inserted");
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
