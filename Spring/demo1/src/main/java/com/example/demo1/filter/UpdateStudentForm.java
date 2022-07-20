package com.example.demo1.filter;

import com.example.demo1.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateStudentForm {
    private String email;
    private String username;
    private String fullname;
    private String password;


    public Student convertToStudent() {
        Student student = new Student();
        student.setEmail(email);
        student.setFullname(fullname);
        student.setUsername(username);
        student.setPassword(password);
        return student;
    }
}
