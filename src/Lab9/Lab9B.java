package Lab9;
// Inheritance Mapping 

// 3) Table Per Concrete class Mapping using XML Configuration
// Retrieving Records from Student1 table and related tables(CurrentStudent1,WeekdayStudent1,WeekendStudent1,OldStudent1) which are inherited from student table using XML configuration

import org.hibernate.*;

public class Lab9B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Student stu = (Student) session.load(Student.class, 1); // Hibernate is Loading the single Table data using
																	// Select Fetch(No Join).Because each P.C class is
																	// mapped with different separate independent Table
																	// and and P.K also different of respective Table
			System.out.println(stu);

			CurrentStudent cst = (CurrentStudent) session.load(CurrentStudent.class, 1);
			System.out.println(cst);

			OldStudent ost = (OldStudent) session.load(OldStudent.class, 1);
			System.out.println(ost);

			WeekdayStudent wdst = (WeekdayStudent) session.load(WeekdayStudent.class, 1);
			System.out.println(wdst);

			WeekendStudent west = (WeekendStudent) session.load(WeekendStudent.class, 1);
			System.out.println(west);

			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
