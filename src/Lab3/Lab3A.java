package Lab3;
// Inserting Records in Students table and related tables which are associated with student table using XML configuration
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Lab3A {

	public static void main(String[] args) {
		Transaction tx = null;
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			tx = session.beginTransaction();
			
			String course[] = {"Java","JDBC","JSP"};
			
			List<String> emails = new ArrayList<>();
			emails.add("aa@gmail.com");
			emails.add("bb@gmail.com");
			emails.add("cc@gmail.com");
			
			List<Integer> marks = new ArrayList<>();
			marks.add(100);
			marks.add(99);
			marks.add(80);
			
			Set<Long> phones = new LinkedHashSet<>();
			phones.add(111111L);
			phones.add(222222L);
			phones.add(333333L);
			
			Map<String, Long> refs = new LinkedHashMap<>();
			refs.put("aaa", 44444L);
			refs.put("bbb", 55555L);
			refs.put("ccc", 66666L);
			
			Student stu = new Student("Dev", "05-03-1994", "B-tech", course, emails, marks, phones, refs);
			session.save(stu);
			
			tx.commit();
			session.close();
		}catch(Exception e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
		}
	}

}
