package com.vti.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.catalina.startup.FailedContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.service.AccountService;

import entity.Account;
import entity.Department;

@RestController
@RequestMapping("/v1/api")
public class AccountController {
	AccountService acService;

	public AccountController() {
		acService = new AccountService();
	}

	@GetMapping(value = "/account")
	public List<Account> getAll(int page, int size) {
		return acService.getAll(page, size);
	}

	@GetMapping(value = "/accounts/{idAccount}")
	public Account getAccountById(@PathVariable(value =  "idAccount")int i) {
		return acService.getAccountById(i);
	}

	public boolean deleteAccountById(int id) {
		try {
			acService.deleteAccountById(id);
			System.out.println("Xóa thành công");
			return true;
		} catch (EntityNotFoundException e) {
			System.out.println("Id khong tin tai");
			return false;
		}
	}

}
