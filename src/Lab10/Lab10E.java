package Lab10;
// Inheritance Mapping 

// 3) Table Per Concrete class Mapping using Annotation Configuration
// Inserting Records in WeekendStudent1 table using Annotation configuration

import org.hibernate.*;

public class Lab10E {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			// 5. Adding the WeekendStudent
			WeekendStudent wstu = new WeekendStudent("SSS", "Delhi", "Enabled", 17000.00, 14000.00, "6:30 p.m", "BTM",
					"Google", "sss@google.com", 40.0);
			wstu.setSid(1); // Setting ID value, We have to pass P.K value explicitly in this case
			Integer it = (Integer) session.save(wstu); // returns P.K Value which is generated for this INSERT Query
			System.out.println(it.intValue()); // 1

			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

}
