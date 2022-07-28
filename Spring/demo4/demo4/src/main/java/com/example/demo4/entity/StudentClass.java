package com.example.demo4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "STUDENTCLASS")
public class StudentClass implements Serializable {
    @Column(name = "idcl")
    @Id
    private int idcl;
    @Column(name = "classname")
    private String classname;

//    @OneToMany(mappedBy = "classid")
//    private List<Student> students;
//
//    public void setStudent(List<Student> students) {
//        this.students = students;
//    }

}
