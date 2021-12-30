package TestingSystem;

import java.time.LocalDate;

import entity.Account;
import utils.ScannerUtil;

public class TestingSystem3 {
//	Khai báo 2 số lương có kiểu dữ liệu là float.
//	Khởi tạo Lương của Account 1 là 5240.5 $
//	Khởi tạo Lương của Account 2 là 10970.055$
//	Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//	Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
	public void ex1q1() {
		float Salary1;
		float Salary2;
		Salary1 = (float) 5240.5;
		Salary2 = (float) 10970.055;
		System.out.println("Salary1: " + Salary1 + "|| Salary2: " + Salary2);
		int intSalary1 = (int) Salary1;
		int intSalary2 = (int) Salary2;
		System.out.println("intSalary1: " + intSalary1 + " || intSalary2: " + intSalary2);
	}

	// Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	public void ex1q2() {
		int a, b;

		System.out.println("Nhập a = ");
		a = ScannerUtil.scanInt();
		do {
			System.out.println("Nhập b = ");

			b = ScannerUtil.scanInt();
			if (b == 0) {
				System.out.println("Vui lòng nhập b khác 0 !");
			}
		} while (b == 0);

		System.out.println("Thương: " + (float) a / (float) b);
	}

	public void ex2q2() {

		Account[] accArray = new Account[5];
		for (int i = 0; i < accArray.length; i++) {
			Account acc = new Account();
			acc.email = "Email " + i;
			acc.userName = "User name " + i;
			acc.fullName = "Full name " + i;
			acc.createDate = LocalDate.now();
			accArray[i] = acc;
			System.out.println(

					"Thông tin Account " + i + " Email: " + accArray[i].email + " UserName: " + accArray[i].userName
							+ " FullName: " + accArray[i].fullName + " CreateDate: " + accArray[i].createDate);

		}
	}
}
