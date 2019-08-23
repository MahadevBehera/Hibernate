package Lab36;
// Display All Customers from customers table using XML configuration and Native Query Language
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab36A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// A) Display All Customers
			String sql = "select {cust.*} from customers cust";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("cust", Customer.class);
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
