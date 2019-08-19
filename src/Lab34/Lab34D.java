package Lab34;
//  Display the Customers by city and status from customers table using XML configuration and Named Query Language
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab34D {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// D) Display the Customers by city and status
			Query query= session.getNamedQuery("CustomersByCityAndStatus"); // Exactly same name which is specified
			query.setString(0, "Blore");
			query.setString(1, "ACTIVE");
			List<Customer> list = query.list();
			
			list.forEach(System.out :: println); // Java 8 feature -- Method reference
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
