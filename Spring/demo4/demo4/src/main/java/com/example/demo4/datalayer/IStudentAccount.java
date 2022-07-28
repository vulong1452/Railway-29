package com.example.demo4.datalayer;

import com.example.demo4.entity.StudentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentAccount extends JpaRepository<StudentAccount,Integer> {
      StudentAccount findByUsername(String username);
}
