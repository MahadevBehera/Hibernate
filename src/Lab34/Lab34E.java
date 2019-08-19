package Lab34;

//  Display the Customers with Pagination from customers table using XML configuration and Named Query Language
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab34E {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// E) Display the Customers with Pagination
			Query query = session.getNamedQuery("AllCustomers"); // Exactly same name which is specified
			query.setFirstResult(0);
			query.setMaxResults(5);
			List<Customer> list = query.list();

			list.forEach(System.out::println); // Java 8 feature -- Method reference

			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
