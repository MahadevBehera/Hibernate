package Lab6;

// Inheritance Mapping 
// 1) Table Per Subclass Mapping using Annotation Configuration
// Inserting Records in Students table and related tables which are inherited from student table using Annotation configuration
import org.hibernate.*;

public class Lab6A {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			// 1. Adding the Student
			Student stu = new Student("Dev", "Kolkata", "Enabled", 15000.00);
			Integer it = (Integer) session.save(stu); // returns P.K Value which is generated for this INSERT Query
			System.out.println(it.intValue()); // 6 // Count starts from 6, Becoz in XML based we already submitted 5 DB
												// operation to same database and same tables
												// So, the Generated P.K value for ID column is 6 for this INSERT Query
												// Here Annotation based Hibernate is not generated P.K so after INSERT
												// Query submission it returning the P.K value which is generated by DB
			// 2. Adding the CurrentStudent
			CurrentStudent cstu = new CurrentStudent("Mahadev", "Bangalore", "Enabled", 2000.00, 1000.00, "6:30 p.m",
					"BTM");
			it = (Integer) session.save(cstu);
			System.out.println(it.intValue()); // 7

			// 3. Adding the OldStudent
			OldStudent ostu = new OldStudent("DDD", "Blore", "Enabled", 14000.00, "TCS", "ddd@tcs.com", 9.0);
			it = (Integer) session.save(ostu);
			System.out.println(it.intValue()); // 8

			// 4. Adding the WeekdayStudent
			WeekdayStudent wdstu = new WeekdayStudent("PPP", "Kolkata", "Enabled", 16000.00, 12000.00, "6:30 p.m",
					"BTM", "B-tech", "82", 2016);
			it = (Integer) session.save(wdstu);
			System.out.println(it.intValue()); // 9

			// 5. Adding the WeekendStudent
			WeekendStudent wstu = new WeekendStudent("SSS", "Delhi", "Enabled", 17000.00, 14000.00, "6:30 p.m", "BTM",
					"Google", "sss@google.com", 40.0);
			it = (Integer) session.save(wstu);
			System.out.println(it.intValue()); // 10

			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
