package Lab17;
import java.util.*;

// Association Mapping 
// 3) (Many-To-Many Bi-Directional Mapping)
// Retrieving Record from Mycourses to Mystudents table using XML configuration (Select Fetch & Lazy Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab17C {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading Course (SELECT QUERY on Mycourses table)
			Course c1 = (Course)session.load(Course.class, 1);
			System.out.println("*********************** Courses Info **********************");
			System.out.println(c1);
			
			System.out.println("*********************** Student Info **********************");
			// Loading Student using Course Data 2st relation (SELECT QUERY on Mystudents table and joined "stu_cou" table also to fetch data using cid of Mycourses)
			Set<Student> students = c1.getStudents(); // Mystudents table data Loaded here one time
			for (Student student : students) {
				System.out.println(student);
			}
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
