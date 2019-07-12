package Lab5;
// Inheritance Mapping 
// 1) Table Per Subclass Mapping using XML Configuration
// Inserting Records in Students table and related tables which are inherited from student table using XML configuration
import org.hibernate.*;

public class Lab5A {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			// 1. Adding the Student
			Student stu = new Student("Dev", "Kolkata", "Enabled", 15000.00);
			Integer it = (Integer) session.save(stu); // returns the count of DB operation using single session
			System.out.println(it.intValue()); // 1

			// 2. Adding the CurrentStudent
			CurrentStudent cstu = new CurrentStudent("Mahadev", "Bangalore", "Enabled", 2000.00, 1000.00, "6:30 p.m",
					"BTM");
			it = (Integer) session.save(cstu);
			System.out.println(it.intValue()); // 2

			// 3. Adding the OldStudent
			OldStudent ostu = new OldStudent("DDD", "Blore", "Enabled", 14000.00, "TCS", "ddd@tcs.com", 9.0);
			it = (Integer) session.save(ostu);  
			System.out.println(it.intValue()); // 3

			// 4. Adding the WeekdayStudent
			WeekdayStudent wdstu = new WeekdayStudent("PPP", "Kolkata", "Enabled", 16000.00, 12000.00, "6:30 p.m",
					"BTM", "B-tech", "82", 2016);
			it = (Integer) session.save(wdstu);
			System.out.println(it.intValue()); // 4

			// 5. Adding the WeekendStudent
			WeekendStudent wstu = new WeekendStudent("SSS", "Delhi", "Enabled", 17000.00, 14000.00, "6:30 p.m", "BTM",
					"Google", "sss@google.com", 40.0);
			it = (Integer) session.save(wstu);
			System.out.println(it.intValue()); // 5

			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
