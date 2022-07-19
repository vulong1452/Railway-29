package com.example.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Column(name = "id")
    @Id

    private int id;

    @Column(name = "email")
    private String email;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;



}
