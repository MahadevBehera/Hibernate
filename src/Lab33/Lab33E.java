package Lab33;

//  Display the Customers by email from customers table using XML configuration and QBC (Query By Criteria)
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Lab33E {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// E) Display the Customers by email
			Criteria ct = session.createCriteria(Customer.class);
			ct.add(Restrictions.eq("email", "dev@gmail.com"));
			Customer cust = (Customer)ct.uniqueResult();
			System.out.println(cust);
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
