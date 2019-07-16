package Lab10;
// Inheritance Mapping 

// 3) Table Per Concrete class Mapping using Annotation Configuration
// Inserting Records in OldStudent1 table using Annotation configuration

import org.hibernate.*;

public class Lab10C {

	public static void main(String[] args) {
		Transaction tx = null;

		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();

			// 3. Adding the OldStudent
			OldStudent ostu = new OldStudent("DDD", "Blore", "Enabled", 14000.00, "TCS", "ddd@tcs.com", 9.0);
			ostu.setSid(1); // Setting ID value, We have to pass P.K value explicitly in this case
			Integer it = (Integer) session.save(ostu); // returns P.K Value which is generated for this INSERT Query
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
