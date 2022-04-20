package Ultis;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.Account;
import entity.Department;
import entity.Exam;
import entity.Question;

public class HibernateUtil {
	private final static SessionFactory FACTORY;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		cfg.addAnnotatedClass(Account.class);//khai báo mapping với CSDL
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Exam.class);
		cfg.addAnnotatedClass(Question.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		FACTORY = cfg.buildSessionFactory(registry);
	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}

}
