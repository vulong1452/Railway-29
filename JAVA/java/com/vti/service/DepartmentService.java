package com.vti.service;

import java.util.List;

import com.vti.datalayer.DepartmentRepository;

import entity.Department;

public class DepartmentService {
	DepartmentRepository repository;

	public DepartmentService() {
		repository = new DepartmentRepository();
	}

	public List<Department> getAll(int page, int size) {
		return repository.getAllDp(page, size);
	}

	public Department updateDepartment(int id, String newName) {
		return repository.updateDepartment(id, newName);
	}

	public boolean deleteDepartmentById(int id) {
		return repository.deleteDepartmentById(id);

	}

	public Department createDepartment(Department department) {
		return repository.createDepartment(department);
	}

	public Department getDepartmentById(int i) {
		return repository.getDepartmentById(i);
	}
	
	public Department getDepartmentByName(String name) {
		return repository.getDepartmentByName(name);
	}
}
