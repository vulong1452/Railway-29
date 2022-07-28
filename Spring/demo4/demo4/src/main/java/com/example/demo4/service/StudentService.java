package com.example.demo4.service;

import com.example.demo4.datalayer.IStudentAccount;
import com.example.demo4.datalayer.IStudentClass;
import com.example.demo4.datalayer.IStudentRepository;
import com.example.demo4.entity.Student;
import com.example.demo4.entity.StudentAccount;
import com.example.demo4.entity.StudentClass;
import com.example.demo4.entity.form.CreateStudentForm;
import com.example.demo4.entity.form.LogInForm;
import com.example.demo4.filter.LogInException;
import com.example.demo4.filter.StudentFilter;
import com.example.demo4.specification.StudentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class StudentService implements UserDetailsService {
    @Autowired
    IStudentRepository repository;

    @Autowired
    IStudentClass stClass;

    @Autowired
    IStudentAccount studentAccount;

public StudentService(){

}
    public Page<Student> getAll(Pageable pageable, StudentFilter filter) {
        Specification<Student> studentSpecification = StudentSpecification.buildWhere(filter);
        return repository.findAll(studentSpecification,pageable);
    }

    public Student getStudentByID(int id) {
        return repository.findById(id).get();
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(int id, CreateStudentForm form) {
        Student student1 = repository.findById(id).get();
        student1.setId(form.getId());
        student1.setEmail(form.getEmail());
        student1.setFullname(form.getFullname());
//        StudentAccount studentAccount1 = studentAccount.findById(form.getAccountid()).get();
//        student1.setAccount(studentAccount1);
//        StudentClass studentClass = stClass.findById(form.getClassid()).get();
//        student1.setClassid(studentClass);
        return repository.save(student1);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StudentAccount student = studentAccount.findByUsername(username);
        if (student == null){
            throw new UsernameNotFoundException("Not found username");
        }
        UserDetails userDetails = new User(
                student.getUsername(),
                student.getPassword(), AuthorityUtils.createAuthorityList(student.getRole())
        );
        return userDetails;
    }

    public StudentAccount getStudentByUserName(String username) {
        return studentAccount.findByUsername(username);
    }

    public StudentAccount login(LogInForm form) throws LogInException {
        StudentAccount student = studentAccount.findByUsername(form.getUsername());
        if (student == null){
            throw new LogInException("Username Not Correct");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean check =  encoder.matches(form.getPassword(), student.getPassword());
        if (check ){
            return student;
        }
        throw new LogInException("Password Not Correct");
    }
}
