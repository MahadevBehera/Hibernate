package Lab22;
 // Inserting Record in customers table using Annotation configuration and Its a example Of Timestamp Mapping also
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab22A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			Customer cust = new Customer("Dev", "dev@gmai.com", 9339158699L);
			session.save(cust);
			
			Customer cust1 = new Customer("Ram", "ram@gmai.com", 933999999L);
			session.save(cust1);
			
			tx.commit();
			session.close();
			System.out.println("Record Inserted");
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
