package com.example.demo1.service;

import com.example.demo1.datalayer.StudentRepository;
import com.example.demo1.entity.Student;

import java.util.List;

public class StudentService {
    StudentRepository repository;

    public StudentService(){
        repository = new StudentRepository();
    }

    public List<Student> getAll(){
        return repository.getAll();
    }

    public Student getStudentByID(int id) {
        return repository.getStudentByID(id);
    }

    public boolean createStudent(Student student) {
        return repository.createStudent(student);
    }

    public String updateStudent(int id, String newUsername) {
        return repository.updateStudent(id,newUsername);
    }

    public boolean deleteStudent(int id) {
        return repository.deleteStudent(id);
    }
}
