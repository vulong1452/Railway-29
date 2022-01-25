package com.vti.backend.business;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountDao;
import com.vti.backend.datalayer.AccountDaoImpl;
import com.vti.entity.Account;

public class AccountServiceImpl implements IAccountService{

	private AccountDao accountDao;
	
	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}
	
	public List<Account> getAllAccount() throws SQLException {
		
		return accountDao.getAllAccounts();
	}

	public Account findAccByUserName(String uName) throws SQLException {
		String uNameLowerCase = uName.toLowerCase().trim();
		return accountDao.findAccByUserName(uNameLowerCase);
	}
	
}
