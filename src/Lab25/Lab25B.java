package Lab25;
// Retrieving Record from customers table using Annotation configuration and the avoided column data will not come from DB bcoz the column it self is not present
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab25B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = (Customer)session.load(Customer.class, 1);
			System.out.println(cust); // email will be null and phone will be 0 here bcoz at the time of inserting we have avoided the column insertion so in customers table the column not created and the data is not there. 
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
