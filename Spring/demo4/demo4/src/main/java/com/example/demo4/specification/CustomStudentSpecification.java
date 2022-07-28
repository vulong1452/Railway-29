package com.example.demo4.specification;

import com.example.demo4.entity.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomStudentSpecification implements Specification<Student> {
    String key;
    String value;

    public CustomStudentSpecification(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    //sinh ra cac cau lenh where don le
    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if ("key_email".equals(key)) {
            return criteriaBuilder.like(root.get("email"), "%" + value + "%");
        }
        if ("key_fullName".equals(key)) {
            return criteriaBuilder.like(root.get("fullname"), "%" + value +"%");
        }
        return null;
    }
}
