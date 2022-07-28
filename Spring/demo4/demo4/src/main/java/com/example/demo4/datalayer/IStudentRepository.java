package com.example.demo4.datalayer;

import com.example.demo4.entity.Student;
import com.example.demo4.filter.StudentFilter;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface IStudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
//    Page<Student> findAll(Pageable pageable);

    Page<Student> findAll(Specification<Student> studentSpecification, Pageable pageable );

//    Student findByFullname(String fullname);
}
