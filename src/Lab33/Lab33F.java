package Lab33;

//  Display the Customers by city and status from customers table using XML configuration and QBC (Query By Criteria)
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Lab33F {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// F) Display the Customers by city and status
			Criteria ct = session.createCriteria(Customer.class);
			Criterion city = Restrictions.eq("city", "Blore");
			Criterion status = Restrictions.eq("status", "INACTIVE");
			ct.add(Restrictions.and(city, status));
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
