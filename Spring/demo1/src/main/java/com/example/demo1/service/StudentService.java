package com.example.demo1.service;

import com.example.demo1.datalayer.StudentRepository;
import com.example.demo1.entity.Student;
import com.example.demo1.filter.CreateStudentForm;
import com.example.demo1.filter.StudentFilter;
import org.springframework.stereotype.Service;

import java.util.List;


public class StudentService {
    StudentRepository repository;

    public StudentService(){
        repository = new StudentRepository();
    }

    public List<Student> getAll(int page, int size, StudentFilter filter){
        return repository.getAll(page,size,filter);
    }

    public Student getStudentByID(int id) {
        return repository.getStudentByID(id);
    }

//    public boolean createStudent(Student student) {
//        return repository.createStudent(student);
//    }
//
//    public String updateStudent(int id, String newUsername) {
//        return repository.updateStudent(id,newUsername);
//    }

    public boolean deleteStudent(int id) {
        return repository.deleteStudent(id);
    }

    public Student createStudent(Student student) {
        return  repository.createStudent(student);
    }


    public Student updateStudent(int id,Student account) {
        return repository.updateStudent(id,account);
    }
}
