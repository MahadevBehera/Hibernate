package Lab32;

//  Display the Customers by cities from customers table using XML configuration and HQL (Hibernate Query Language)
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab32L {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// L) Display the Customers by cities (Named Parameter)
			String hql = "from Customer cust where cust.city in (:cities)";
			// String hql = "from Customer cust where cust.city in (?,?)"; // For Positional Parameter
			Query query = session.createQuery(hql);
			query.setParameterList("cities", new String[] { "Blore", "Hyd" });
			/*
			 * ** For Positional Parameter ** 
			 * query.setParameter(0, "Blore");
			 * query.setParameter(1, "Hyd");
			 */
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
