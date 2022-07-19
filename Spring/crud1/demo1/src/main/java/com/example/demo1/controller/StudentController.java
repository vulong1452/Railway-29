package com.example.demo1.controller;

import com.example.demo1.entity.Student;
import com.example.demo1.service.StudentService;
import com.example.demo1.util.HibernateUtils;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/student")
public class StudentController {
    StudentService stService;

    public StudentController(){
        stService = new StudentService();
    }

    @GetMapping
    public List<Student> getAll(){
        return stService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentByID(@PathVariable(value = "id") int id){
        return stService.getStudentByID(id);
    }


    public boolean createStudent(Student student){
        return stService.createStudent(student);
    }

    @PutMapping(value = "/{id}")
    public String updateStudent(@PathVariable(value = "id") int id,@RequestBody String newUsername){
        return stService.updateStudent(id,newUsername);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteStudent(@PathVariable(value = "id") int id){
        try {
            stService.deleteStudent(id);
            System.out.println("Delete Success");
            return true;

        }catch (EntityNotFoundException e){
            System.out.println("Khong tim thay id can xoa");
            return false;
        }

    }

}
