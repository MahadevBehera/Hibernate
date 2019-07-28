package Lab17;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
//		cfg = cfg.configure(); // By default it will pick hibernate.cfg.xml from src folder(/src/hibernate.cfg.xml)
		cfg = cfg.configure("/Lab17/hibernate.cfg.xml");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssr= ssrb.applySettings(cfg.getProperties()).build();
		factory = cfg.buildSessionFactory(ssr);
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
