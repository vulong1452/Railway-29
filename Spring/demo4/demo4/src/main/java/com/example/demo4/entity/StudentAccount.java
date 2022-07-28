package com.example.demo4.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ACCOUNT")
public class StudentAccount implements Serializable {

    @Column(name = "accountid")
    @Id

    private int accountId;
    @Column(name = "role")
    private String role;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
