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
		float salary1;
		float salary2;
		salary1 = (float) 5240.5;
		salary2 = (float) 10970.055;
		System.out.println("Salary1: " + salary1 + "|| Salary2: " + salary2);
		int intSalary1 = (int) salary1;
		int intSalary2 = (int) salary2;
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

//	Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
//	tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
//	• Email: "Email 1"
//	• Username: "User name 1"
//	• FullName: "Full name 1"
//	• CreateDate: now
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

//	Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//	float có 2 số sau dấu thập phân)
	public void ex3q1() {
		Integer salary = 5000;
		System.out.printf("2.2f", (float) salary);
	}

//	Khai báo 1 String có value = "1234567"
//			Hãy convert String đó ra số int
	public void ex3q2() {
		String s = "1234567";
		int i = Integer.parseInt(s);
		System.out.println(i);
	}

//	Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//	thể cách nhau bằng nhiều khoảng trắng ); => đáp án chưa chính xác, cần xem lại
	public void ex4q1() {
		String s1;
		System.out.println("Nhập : ");
		s1 = ScannerUtil.scanString();
		String[] words = s1.split(" ");
		System.out.println("Số kí tự: " + words.length);
	}

	// nhập 2 xâu kí tự s1,s2 nối xâu kí tự s2 sau xâu kí tự s1
	public void ex4q2() {
		System.out.println("Nhập vào chuỗi 1: ");
		String s1 = ScannerUtil.scanString();
		System.out.println("Nhập vào chuỗi 2: ");
		String s2 = ScannerUtil.scanString();
		System.out.println("Kết quả sau khi nối chuỗi: " + s1 + " " + s2);
	}

//	Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//	dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	public void ex4q5() {
		System.out.println("Nhập họ: ");
		String firstName = ScannerUtil.scanString();
		System.out.println("Nhập tên: ");
		String lastName = ScannerUtil.scanString();
		System.out.println("Họ tên đầy đủ: " + firstName + " " +lastName);
	}
}
