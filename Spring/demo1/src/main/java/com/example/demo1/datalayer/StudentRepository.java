package com.example.demo1.datalayer;

import com.example.demo1.entity.Student;
import com.example.demo1.filter.StudentFilter;
import com.example.demo1.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {

    public List<Student> getAll(int page, int size, StudentFilter filter){
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            String hql = "FROM Student s";

            if (filter.getUsername() != null && filter.getEmail()!= null) {
                hql = String.format("FROM Student s WHERE s.username = '%s' OR s.email = '%s'", filter.getUsername(), filter.getEmail());
            }else if (filter.getUsername()!= null) {
                hql = String.format("FROM Student s WHERE s.username = '%s'", filter.getUsername());
            }else if (filter.getEmail()!=null){
                hql = String.format("FROM Student s WHERE s.email = '%s'",filter.getEmail());
            }
            int offset = page   * size;
            Query<Student> query = session.createQuery(hql,Student.class);
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.list();
        }finally {
            if (session != null){
                session.close();
            }
        }


    }

    public Student getStudentByID(int id) {
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            Student student = session.get(Student.class, id);
            return student;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
//    public boolean createStudent(Student student){
//        Session session = null;
//        try {
//            session = HibernateUtils.getFactory().openSession();
//            session.beginTransaction();
//            session.save(student);
//            session.getTransaction().commit();
//        }finally {
//            if (session != null){
//                session.close();
//            }
//        }
//        return false;
//    }
//
//    public String updateStudent(int id, String newUsername){
//        Session session = null;
//        try {
//            session = HibernateUtils.getFactory().openSession();
//            session.beginTransaction();
//            Student student = (Student) session.load(Student.class,id);
//            student.setUsername(newUsername);
//            session.getTransaction().commit();
//        }finally {
//            if (session!=null){
//                session.close();
//            }
//        }
//        return newUsername;
//    }

    public boolean deleteStudent(int id){
        Session session =null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            Student student = (Student) session.load(Student.class,id);
            session.delete(student);
            session.getTransaction().commit();
            return true;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    public Student updateStudent(int id, Student student) {
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            Student student1 = session.get(Student.class,id);
            if (student1 == null){
                return  null;
            }

            session.beginTransaction();
            if (student1.getEmail()!=null){
                student1.setEmail(student.getEmail());
            }
            if (student1.getFullname()!=null){
                student1.setFullname(student.getFullname());
            }
            if (student1.getUsername()!=null){
                student1.setUsername(student.getUsername());
            }
            session.save(student1);
            session.getTransaction().commit();
            return student1;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    public Student createStudent(Student student) {
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return student;
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }
}
