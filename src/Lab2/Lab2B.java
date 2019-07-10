package Lab2;
// Retrieving Record from customers table using Annotations configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab2B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Customer cust = (Customer)session.load(Customer.class, 3);
			cust.setEmail("mahadev@gmai.com"); // Same email i am setting again, No dirty Object, It will not update data bcoz of Data is same
			session.update(cust);
			// session.delete(cust); // to delete record
			System.out.println(cust);
			
			tx.commit();
			session.close();
			System.out.println(cust); // Detached Object
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
