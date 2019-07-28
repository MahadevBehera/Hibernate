package Lab18;
 import java.util.*;

 // Association Mapping 
 // 3) (Many-To-Many Bi-Directional Mapping)
 // Inserting Record in Mystudents table and Mycourses table and making relation Many to Many between Students and Courses using Annotation configuration
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab17A {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			// Creating 1st Student
			Student s1 = new Student("Dev", "dev@gmail.com", 9999999);
			// Creating 2nd Student
			Student s2 = new Student("Mahadev", "mahadev@gmail.com", 8888888);
			// Creating 3rd Student
			Student s3 = new Student("Devil", "devil@gmail.com", 77777777);
			
			// Storing all Students to Mystudents table
			session.save(s1); session.save(s2); session.save(s3);
			
			// Creating 1st Course
			Course c1 = new Course("Java", 10000.00, 9);
			// Creating 2nd Course
			Course c2 = new Course("JDBC", 20000.00, 3);
			// Creating 3rd Course
			Course c3 = new Course("JSP", 5000.00, 1);
			
			// Storing all Courses to MyCourses table
			session.save(c1); session.save(c2); session.save(c3);
			
			// Associating Courses to Students (s1 joined for c1 and c2, 1st relation)
			Set<Course> courses1 = new LinkedHashSet<>();
			courses1.add(c1); courses1.add(c2);
			s1.setCourses(courses1); // 2 records will INSERT in 3rd table("stu_cou" table)
			

			// Associating Courses to Students (s2 joined for c1,c2 and c3, 1st relation**)
			Set<Course> courses2 = new LinkedHashSet<>();
			courses2.add(c1); courses2.add(c2); courses2.add(c3);
			s2.setCourses(courses2); // 3 records will INSERT in 3rd table("stu_cou" table)
			
			// Associating Students to Courses (c3 joined by s1 and s3, 2nd relation**)
			Set<Student> students1 = new LinkedHashSet<>();
			students1.add(s1); students1.add(s3);
			c3.setStudents(students1); // 2 records will INSERT in 3rd table("stu_cou" table)
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
