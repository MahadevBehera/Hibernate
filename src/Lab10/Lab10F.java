package Lab10;
// Inheritance Mapping 

// 3) Table Per Concrete class Mapping using Annotation Configuration
// Retrieving Records from WeekendStudent1 Table only in a single session we can load one P.C Data using Annotation configuration

import org.hibernate.*;

public class Lab10F {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			Student stu = (WeekendStudent) session.load(WeekendStudent.class, 1); // Hibernate is Loading the single
																					// Table data using Select Fetch(No
																					// Join).Because each P.C class is
																					// mapped with different separate
																					// independent Table and and P.K
																					// also different of respective
																					// Table, Sometimes it uses union
																					// when we try to load super type
																					// class data.
			System.out.println(stu);

			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
