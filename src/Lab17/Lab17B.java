package Lab17;
import java.util.*;

// Association Mapping 
// 3) (Many-To-Many Bi-Directional Mapping)
// Retrieving Record from Mystudents to Mycourses table using XML configuration (Select Fetch & lazy Loading)
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab17B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Loading Student (SELECT QUERY on Mystudents table)
			Student s1 = (Student)session.load(Student.class, 1);
			System.out.println("*********************** Student Info **********************");
			System.out.println(s1);
			
			System.out.println("*********************** Courses Info **********************");
			// Loading Course using Student Data 1st relation (SELECT QUERY on Mycourses table and joined "stu_cou" table also to fetch data using sid of Mystudents)
			Set<Course> courses = s1.getCourses(); // Mycourses table data Loaded here one time
			for (Course course : courses) {
				System.out.println(course);
			}
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
