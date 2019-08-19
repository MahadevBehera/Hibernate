package Lab34;
//  Display the Customers by email from customers table using XML configuration and Named Query Language
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab34C {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// C) Display the Customers by email
			Query query= session.getNamedQuery("CustomersByEmail"); // Exactly same name which is specified
			query.setString(0, "dev@gmail.com");
			Object[] obj = (Object[])query.uniqueResult(); // we didn't specify the <return> tag so thats why we are getting Object Type Array which is holding all column data of single unique record of customers table which have email="dev@gmail.com".
			
			for (Object object : obj) {
				System.out.print(object+"\t");
			}
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
