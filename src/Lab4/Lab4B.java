package Lab4;
// Retrieving Records from Students table and related tables which are associated with student table using Annotation configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab4B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Student stu = (Student)session.load(Student.class, 1);
			System.out.println(stu);
			
			for (String cn : stu.getCourses()) {
				System.out.println(cn);
			}
			
			System.out.println(stu.getEmails());
			System.out.println(stu.getMarks());
			System.out.println(stu.getPhones());
			System.out.println(stu.getRefs());
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
