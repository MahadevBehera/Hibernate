package Lab10;
// Inheritance Mapping 

// 3) Table Per Concrete class Mapping using Annotation Configuration
// Inserting Records in CurrentStudent1 table using Annotation configuration

import org.hibernate.*;

public class Lab10B {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			// 2. Adding the CurrentStudent
			CurrentStudent cstu = new CurrentStudent("Mahadev", "Bangalore", "Enabled", 2000.00, 1000.00, "6:30 p.m",
					"BTM");
			cstu.setSid(1); // Setting ID value, We have to pass P.K value explicitly in this case
			Integer it = (Integer) session.save(cstu); // returns P.K Value which is generated for this INSERT Query
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
