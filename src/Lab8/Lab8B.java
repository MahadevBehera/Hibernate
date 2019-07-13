package Lab8;
// Inheritance Mapping 
// 2) Table Per Class Mapping using Annotation Configuration
// Retrieving Records from AllStudents table(only one table) and related classes which are inherited from Student class those data also will come from same table using Annotation configuration

import org.hibernate.*;

public class Lab8B {

	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			Student stu = (Student) session.load(Student.class, 1); // Hibernate is  Loading all tables data using Join
			System.out.println(stu);
			
			CurrentStudent cst = (CurrentStudent)session.load(CurrentStudent.class, 2);
			System.out.println(cst);
			
			OldStudent ost = (OldStudent)session.load(OldStudent.class, 3);
			System.out.println(ost);
			
			WeekdayStudent wdst = (WeekdayStudent)session.load(WeekdayStudent.class, 4);
			System.out.println(wdst);

			WeekendStudent west = (WeekendStudent)session.load(WeekendStudent.class, 5);
			System.out.println(west);
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
