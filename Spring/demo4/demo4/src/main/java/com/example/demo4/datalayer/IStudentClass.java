package com.example.demo4.datalayer;

import com.example.demo4.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentClass extends JpaRepository<StudentClass,Integer> {
}
