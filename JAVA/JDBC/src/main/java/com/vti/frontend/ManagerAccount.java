package com.vti.frontend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.backend.presentation.AccountControllerImpl;
import com.vti.backend.presentation.IAccountController;
import com.vti.entity.Account;
import com.vti.utils.ScannerUtil;

public class ManagerAccount {
	private IAccountController accController;

	public ManagerAccount() {
		accController = new AccountControllerImpl();
		System.out.println("---- Chuong trinh QL Tai khoan ---");
		menu();
	}

	private void menu() {
		int selected = 0;
		do {
			System.out.println("Chon chuc nang :");
			System.out.println("1 - In danh sach account :");
			System.out.println("2 - Tim tai khoan theo user name :");
			System.out.println("3 - Xóa tai khoan :");
			System.out.println("4 - Tạo tai khoan moi :");
			System.out.println("5 - Sửa tài khoản :");
			System.out.println("6 - Thoat :");
			selected = ScannerUtil.scanInt();
			switch (selected) {
			case 1:
				printListAccount();
				break;
			case 2:
				findAccount();
				break;
			case 6:
				System.out.println("Thoat chuong trinh :");

			default:
				System.out.println("Chon sai chuc nang :");
				break;
			}

		} while (selected != 2);

	}

	private void findAccount() {
		System.out.println("--------2. Tìm tài khoản theo Username-------  ");
		System.out.println("Nhập username cần tìm");
		String uName = ScannerUtil.scanString(); 
		Account account =  accController.findAccountByUserName(uName);
		if(account != null) {
			System.out.println(account);
		}else {
			System.out.println("Không tìm thấy tài khoản phù hợp");
		}
	}

	/**
	 * phuong thuc in danh sach account
	 */
	private void printListAccount() {
		List<Account> listAcc = new ArrayList<Account>();
		try {
			listAcc.addAll(accController.getAccount());
			for (Account account : listAcc) {
				System.out.println(account);
				
			}
		} catch (SQLException e) {
			System.err.println("Xay ra loi" + e.getMessage());
		}

	}
}
