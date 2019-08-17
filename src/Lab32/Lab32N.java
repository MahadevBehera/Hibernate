package Lab32;

//  Display the Customers by city with Pagination from customers table using XML configuration and HQL (Hibernate Query Language)
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab32N {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// N) Display the Customers by city with Pagination
			String hql = "from Customer cust where cust.city = ?";
			Query query = session.createQuery(hql);
			query.setString(0, "Blore");
			query.setFirstResult(0);
			query.setMaxResults(2);
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
