package com.example.demo1.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "STUDENTDETAIL")
public class StudentDetail implements Serializable {

    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "phone")
    private int phone;

    @Column(name = "addr")
    private String addr;

    @Column(name = "genders")
    private String gender;
}
