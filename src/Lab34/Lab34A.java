package Lab34;
// Display All Customers from customers table using XML configuration and Named Query Language
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab34A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// A) Display All Customers
			Query query = session.getNamedQuery("AllCustomers"); // Exactly same name which is specified  
			List<Customer> list = query.list();
			
			list.forEach(x -> 
				System.out.println(x)  // Java 8 feature -- functional interface and forEach() 
			);
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
