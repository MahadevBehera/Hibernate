package Lab36;
//  Display the Customers by email from customers table using XML configuration and Native Query Language
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab36C {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// C) Display the Customers by email
			String sql = "select {cust.*} from customers cust where cust.email = ?";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("cust", Customer.class);
			query.setString(0, "dev@gmail.com");
			Customer cust = (Customer)query.uniqueResult();
			System.out.println(cust);
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
