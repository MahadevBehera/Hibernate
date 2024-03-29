package Lab2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
//		cfg = cfg.configure(); // By default it will pick hibernate.cfg.xml from src folder(/src/hibernate.cfg.xml)
		cfg = cfg.configure("/Lab2/hibernate.cfg.xml"); // for MySql configuration and connection
//		cfg = cfg.configure("/Lab2/hibernate-oracle.cfg.xml"); // for Oracle configuration and connection
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr= ssrb.applySettings(cfg.getProperties()).build();
		factory = cfg.buildSessionFactory(ssr);
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
