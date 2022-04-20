package com.vti.service;

import java.util.List;

import com.vti.datalayer.AccountRepository;

import entity.Account;
import entity.Department;

public class AccountService {
	AccountRepository repository;

	public AccountService() {
		repository = new AccountRepository();
	}

	public List<Account> getAll(int page, int size) {
		return repository.getAll(1, 100);
	}

	public Account getAccountById(int i) {
		return repository.getAccountById(i);
	}

	public boolean deleteAccountById(int id) {
		return repository.deleteAccountById(id);
	}

	public void createDepartment(Department department) {
		
	}
}
