package com.example.demo1.util;

import com.example.demo1.entity.Student;
import com.example.demo1.entity.StudentDetail;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;




public class HibernateUtils {

    private final static SessionFactory FACTORY;

    static {
        // load file config
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // add entity
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(StudentDetail.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

        FACTORY = cfg.buildSessionFactory(registry);

    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }

}