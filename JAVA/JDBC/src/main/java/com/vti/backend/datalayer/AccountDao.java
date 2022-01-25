package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface AccountDao {
	
	public List<Account> getAllAccounts() throws SQLException;

	public Account findAccByUserName(String uNameLowerCase) throws SQLException;
}
