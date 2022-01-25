package com.vti.backend.presentation;

import java.sql.SQLException;
import java.util.List;

import javax.print.attribute.standard.JobOriginatingUserName;

import com.vti.backend.business.AccountServiceImpl;
import com.vti.backend.business.IAccountService;
import com.vti.entity.Account;

public class AccountControllerImpl implements IAccountController {

	private IAccountService accService;
	
	public AccountControllerImpl() {
		accService = new AccountServiceImpl();
		
	}
	
	public List<Account> getAccount() throws SQLException {
		
		return accService.getAllAccount();
	}
	
	public Account findAccountByUsername(String uName) throws SQLException {
		if(uName.isBlank() || uName.isEmpty()) {
			return null;
		}
		return accService.findAccByUserName(uName);
	}
}
