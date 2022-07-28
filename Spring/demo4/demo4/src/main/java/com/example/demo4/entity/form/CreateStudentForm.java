package com.example.demo4.entity.form;

import com.example.demo4.entity.StudentClass;
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
    private int accountid;
    private int classid;

}
