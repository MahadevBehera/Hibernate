package Lab5;
// Inheritance Mapping 

// 1) Table Per Subclass Mapping using XML Configuration
// Retrieving Records from Students table and related tables which are inherited from student table using XML configuration

import org.hibernate.*;

public class Lab5B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Student stu = (Student) session.load(Student.class, 1); // Hibernate is Loading all tables data using Join
			System.out.println(stu);

			CurrentStudent cst = (CurrentStudent) session.load(CurrentStudent.class, 2);
			System.out.println(cst);

			OldStudent ost = (OldStudent) session.load(OldStudent.class, 3);
			System.out.println(ost);

			WeekdayStudent wdst = (WeekdayStudent) session.load(WeekdayStudent.class, 4);
			System.out.println(wdst);

			WeekendStudent west = (WeekendStudent) session.load(WeekendStudent.class, 5);
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
