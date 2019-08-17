package Lab32;
// Display All Customers from customers table using XML configuration and HQL (Hibernate Query Language)
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab32A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// A) Display All Customers
			String hql = "from Customer cust";
			Query query = session.createQuery(hql);
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
