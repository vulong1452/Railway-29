package com.example.demo1.filter;

import com.example.demo1.entity.Student;
import com.example.demo1.entity.StudentDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateStudentForm {

    private int id;
    private String email;
    private String username;
    private String fullname;
    private String password;

    private String addr;
    private int phone;
    private String birth;
    private String gender;
    private int iddt;

    public Student convertToStudent() {
        Student student = new Student();
        student.setId(id);
        student.setEmail(email);
        student.setFullname(fullname);
        student.setUsername(username);
        student.setPassword(password);
		return student;
    }


}
