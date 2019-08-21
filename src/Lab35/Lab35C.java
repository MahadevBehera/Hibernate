package Lab35;
//  Display the Customers by email from customers table using Annotation configuration and Named Query Language
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab35C {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// C) Display the Customers by email
			Query query= session.getNamedQuery("CustomersByEmail"); // Exactly same name which is specified
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
