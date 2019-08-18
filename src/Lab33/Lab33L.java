package Lab33;

//  Display the Customers by city with Pagination from customers table using XML configuration and QBC (Query By Criteria)
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Lab33L {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// L) Display the Customers by city with Pagination
			Criteria ct = session.createCriteria(Customer.class);
			ct.add(Restrictions.eq("city", "Blore"));
			ct.setFirstResult(0);
			ct.setMaxResults(2);
			List<Customer> list = ct.list();

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
