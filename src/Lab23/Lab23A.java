package Lab23;
 // Inserting Record in customers table using Annotation configuration and its storing Address class data also into same table using @Embeddable and @Embedded  
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab23A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Address add = new Address();
			add.setCity("Bangalore");
			add.setStreet("BTM");
			Customer cust = new Customer("Dev", add);
			session.save(cust);
			
			tx.commit();
			session.close();
			System.out.println("Record Inserted");
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
