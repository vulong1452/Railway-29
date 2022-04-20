package com.vti;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import com.vti.controller.AccountController;
import com.vti.controller.DepartmentController;
import com.vti.datalayer.AccountRepository;

import entity.A;
import entity.Account;
import entity.Department;
import entity.Question;

@SpringBootApplication
public class SpringHelloApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SpringHelloApplication.class, args);
		 
//		AccountController accountController = new AccountController();
//		for (Account acc : (new AccountRepository()).getAll(2,4)) {
//			System.out.println(acc);}
//		Question q1 = (new AccountRepository()).getQuestionById(1);
//		System.out.println(q1);
//		
//		System.out.println(q1.getListExam());
		
//		accountController.updateDepartment((short)8, "Phong Hop");
//		accountController.deleteDepartmentById(3);
//		DepartmentController departmentController = new DepartmentController();
//		departmentController.getDepartmentByName("Phong Dev 1");
		//create
//		Department creDepartment = new Department();
//		creDepartment.setdPname("Phong cho");
//		creDepartment.setId(9);
//		DepartmentController dpController = new DepartmentController();
//		dpController.createDepartment(creDepartment);
		
		
		
		
		
		
		
		
		
	}

}
