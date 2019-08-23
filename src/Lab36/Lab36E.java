package Lab36;

//  Display the Customers with Pagination from customers table using XML configuration and Native Query Language
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab36E {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// E) Display the Customers with Pagination
			String sql = "select {cust.*} from customers cust";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("cust", Customer.class);
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
