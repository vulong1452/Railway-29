package com.example.demo1.datalayer;

import com.example.demo1.entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
