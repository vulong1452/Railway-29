package com.vti.backend.presentation;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Account;

public interface IAccountController {
	public List<Account> getAccount() throws SQLException;
}
