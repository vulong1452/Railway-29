package com.example.demo4.controller;

import com.example.demo4.entity.StudentAccount;
import com.example.demo4.entity.dto.StudentDTO;
import com.example.demo4.entity.form.CreateStudentForm;
import com.example.demo4.entity.form.LogInForm;
import com.example.demo4.filter.LogInException;
import com.example.demo4.filter.StudentFilter;
import com.example.demo4.service.StudentService;
import com.example.demo4.entity.Student;
import com.example.demo4.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/students")
public class StudentController {
    @Autowired
    StudentService stService;

    @Autowired
    ModelMapper mapper;

    public StudentController(){

    }
    @GetMapping
    public Page<Student> getAll(Pageable pageable,StudentFilter filter){

        Page<Student> students = stService.getAll(pageable,filter);
        return students;
    }

    @GetMapping(value = "/{id}")
    public StudentDTO getStudentByID(@PathVariable(value = "id") int id){
        Student student = stService.getStudentByID(id);
        StudentDTO studentDTO = mapper.map(student,StudentDTO.class);
        return  studentDTO;
    }

    @GetMapping(value = "name/{name}/exists")
    public StudentDTO existsByName(@PathVariable(name = "name") String username){
        StudentAccount student = stService.getStudentByUserName(username);
        StudentDTO dto = mapper.map(student,StudentDTO.class);
        return dto;
    }

    @GetMapping(value = "/login")
    public StudentDTO logIn(LogInForm form) throws LogInException {
        StudentAccount student = stService.login(form);
        StudentDTO dto = mapper.map(student,StudentDTO.class);
        return dto;
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteStudent(@PathVariable(value = "id") int id){
        try {
            stService.deleteStudent(id);
            return true;
        }catch (EntityNotFoundException e){
            return false;
        }
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return stService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateAccount(@PathVariable(name = "id") int id, @RequestBody() CreateStudentForm form) {
        Student student = stService.updateStudent(id, form);
        return student;
    }
}
