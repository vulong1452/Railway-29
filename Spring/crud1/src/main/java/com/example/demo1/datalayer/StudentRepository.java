package com.example.demo1.datalayer;

import com.example.demo1.entity.Student;
import com.example.demo1.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {

    public List<Student> getAll(){
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            Query<Student> query = session.createQuery("FROM Student ");
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
    public boolean createStudent(Student student){
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return false;
    }

    public String updateStudent(int id, String newUsername){
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            Student student = (Student) session.load(Student.class,id);
            student.setUsername(newUsername);
            session.getTransaction().commit();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return newUsername;
    }

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
}
