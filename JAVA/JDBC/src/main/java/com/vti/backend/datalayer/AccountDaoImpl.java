package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.utils.JDBCUtil;

public class AccountDaoImpl implements AccountDao {

	public List<Account> getAllAccounts() throws SQLException {
		List<Account> list = new ArrayList<Account>();

		String query = "SELECT * FROM Account";

		ResultSet resultSet = JDBCUtil.getIntance().getStatement().executeQuery(query);

		while (resultSet.next()) {

			list.add(new Account(resultSet));
		}

		return list;
	}

	public Account findAccByUserName(String uNameLowerCase) throws SQLException {
		Account account = null;
		
		String query = "Select * From Account Where username = ?";
		
		PreparedStatement preparedStatements = JDBCUtil.getIntance().getPreparedStatement(query);
		
		preparedStatements.setString(1, uNameLowerCase);
		ResultSet resultSet = JDBCUtil.getIntance().getStatement().executeQuery(query);
		
		if(resultSet.next()) {
			return new Account(resultSet);
		}
		return null;
	}

}
