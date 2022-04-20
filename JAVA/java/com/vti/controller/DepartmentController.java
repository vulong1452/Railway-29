package com.vti.controller;

import javax.persistence.EntityNotFoundException;

import com.vti.service.DepartmentService;

import entity.Account;
import entity.Department;

public class DepartmentController {
	DepartmentService dpService;

	public DepartmentController() {
		dpService = new DepartmentService();
	}

	public boolean deleteDepartmentById(int id) {
		try {
			dpService.deleteDepartmentById(id);
			System.out.println("Xóa thành công");
			return true;
		} catch (EntityNotFoundException e) {
			System.out.println("Id khong tin tai");
			return false;
		}
	}

	public Department updateDepartment(int id, String newName) {
		return dpService.updateDepartment(id, newName);
	}

	public Department createDepartment(Department department) {
		return dpService.createDepartment(department);
	}

	public Department getAccountById(int i) {
		return dpService.getDepartmentById(i);
	}

	public Department getDepartmentByName(String name) {
		return dpService.getDepartmentByName(name);
	}
}
