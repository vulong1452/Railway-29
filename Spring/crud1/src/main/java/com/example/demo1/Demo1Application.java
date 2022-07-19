package com.example.demo1;

import com.example.demo1.controller.StudentController;
import com.example.demo1.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Demo1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Demo1Application.class, args);

		StudentController studentController = new StudentController();
//		for(Student st: studentController.getAll()){
//			System.out.println(st);
//		}
//		studentController.deleteStudent(6);
//		studentController.updateStudent(3,"vulong1452");

//		System.out.println(studentController.getStudentByID(3));
//		studentController.createStudent(new Student(8,"laskdfj@gmail.com","asdad","asdssad","1234"));
			
		}
	}


