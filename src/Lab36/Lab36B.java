package Lab36;
//  Display the Customers by city from customers table using XML configuration and Native Query Language
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab36B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// B) Display the Customers by city
			String sql = "select {cust.*} from customers cust where cust.city = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("cust", Customer.class);
			query.setString(0, "Blore");
			List<Customer> list = query.list();
			
			list.forEach(System.out :: println); // Java 8 feature -- Method reference
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
