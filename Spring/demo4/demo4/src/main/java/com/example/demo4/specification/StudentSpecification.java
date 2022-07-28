package com.example.demo4.specification;

import com.example.demo4.entity.Student;
import com.example.demo4.filter.StudentFilter;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {
    public static Specification<Student> buildWhere(StudentFilter filter){
        Specification<Student> whereRoot = null;
        if (filter.getEmail()!=null){
            whereRoot = new CustomStudentSpecification("key_email",filter.getEmail());
        }
        if (filter.getFullname()!=null){
            CustomStudentSpecification whereNew = new CustomStudentSpecification("key_userName",filter.getFullname());
            if (whereRoot==null){
                whereRoot=whereNew;
            }else {
                whereRoot=whereRoot.or(whereNew);
            }
        }
        return  whereRoot;
    }
}
