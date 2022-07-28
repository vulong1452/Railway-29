package com.example.demo4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "NEWSTUDENT")
public class Student implements Serializable {

    @Column(name = "id")
    @Id

    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "fullname")
    private String fullname;


    @ManyToOne(targetEntity = StudentClass.class,cascade =CascadeType.ALL)
    @JoinColumn(name = "classid",referencedColumnName = "idcl")
    private StudentClass classid;

    @OneToOne(targetEntity = StudentAccount.class,cascade =CascadeType.ALL)
    @JoinColumn(name = "account",referencedColumnName = "accountid")
    private StudentAccount account;
}
