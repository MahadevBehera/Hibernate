package Lab33;
// Display All Customers from customers table using XML configuration and QBC (Query By Criteria)
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab33A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// A) Display All Customers
			Criteria ct = session.createCriteria(Customer.class);
			List<Customer> list = ct.list();
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
