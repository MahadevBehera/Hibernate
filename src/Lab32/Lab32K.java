package Lab32;

//  Display the Customers by city and cardType from customers table using XML configuration and HQL (Hibernate Query Language)
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab32K {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// K) Display the Customers by city and cardType(Named Parameter)
			String hql = "from Customer cust where cust.city = :mycity and cust.cardType = :ctype";
			Query query = session.createQuery(hql);
			query.setString("mycity", "Blore");
			query.setParameter("ctype", "VISA");
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
