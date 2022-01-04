package entity;

import java.security.PKCS12Attribute;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import entity.Position.PositionName;
import utils.DateUtil;
import utils.ScannerUtil;

public class TestingSystem1 {
	Department dp1, dp2, dp3;
	Department[] listDepartments = new Department[3];

	Position ps1, ps2, ps3;
	Position[] listPositions = new Position[3];

	Account acc1, acc2, acc3, acc4;
	Account[] listAccounts = new Account[4];

	Group gr1, gr2, gr3;
	Group[] listGroups = new Group[3];

	public TestingSystem1() {
		// Department
		dp1 = new Department(1, "Phong Sale");
		dp2 = new Department(2, "Phong Marketing");
		dp3 = new Department(3, "Phong Dev");

		listDepartments[0] = dp1;
		listDepartments[1] = dp2;
		listDepartments[2] = dp3;

		// Position
		ps1 = new Position(1, PositionName.Dev);
		ps2 = new Position(2, PositionName.PM);
		ps3 = new Position(3, PositionName.Scrum_Master);

		listPositions[0] = ps1;
		listPositions[1] = ps2;
		listPositions[2] = ps3;

		// Group
		gr1 = new Group(1, "Nhom 1", acc1);
		gr1.createDate = LocalDate.of(2021, 1, 1);
		gr2 = new Group(2, "Nhom 2", acc2);
		gr2.createDate = LocalDate.of(2020, 1, 1);
		gr3 = new Group(3, "Nhom 3", acc3);
		gr3.createDate = LocalDate.of(2019, 1, 1);

		// Account
		acc1 = new Account(1, "vti_1@gmail.com", "vti_1", "vti1", dp1, ps1);
		acc1.createDate = LocalDate.now();
		// khởi tạo groupAcc1 chứa gr1 và gr2
		Group[] groupAcc1 = { gr1, gr2 };
		// Lưu acc1 vào groupAcc1
		acc1.groups = groupAcc1;
		acc2 = new Account(2, "vti_2@gmail.com", "vti_2", "vti2", dp1, ps2);
		acc2.createDate = LocalDate.of(2021, 03, 17);
		// Lưu acc2 vào gr2,gr3
		acc2.groups = new Group[] { gr3, gr2 };
		acc3 = new Account(3, "vti_2", dp3, ps3);
		acc3.createDate = LocalDate.now();
		acc4 = new Account(4, "vti_4");
		gr1.accounts = new Account[] { acc1 };
		gr2.accounts = new Account[] { acc1, acc2 };
		gr3.accounts = new Account[] { acc2 };

		listAccounts[0] = acc1;
		listAccounts[1] = acc2;
		listAccounts[2] = acc3;
		listAccounts[3] = acc4;

	}

	public void ex1q1() {
		for (int i = 0; i < listAccounts.length; i++) {
			Account a = listAccounts[i];
			if (a.getDepartment() == null) {
				System.out.println(a.getUserName() + "=>Không có phòng ban");
			} else {
				System.out.println(a.getUserName() + "=>" + a.getDepartment().getName());
			}
		}

	}

	/*
	 * Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text
	 * "Nhân viên này chưa có group" Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra
	 * text "Group của nhân viên này là Java Fresher, C# Fresher" Nếu có mặt trong 3
	 * Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều
	 * group" Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
	 * người hóng chuyện, tham gia tất cả các group"
	 */
	public void ex1q2() {
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {
			// tạo biến đếm số lượng gr chứa acc2
			int countGroup = acc2.groups.length;
			if (countGroup == 1 || countGroup == 2) {
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			}
			if (countGroup == 3) {
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");

			}
			if (countGroup >= 4) {
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

			}
		}
	}

	// Sử dụng toán tử ternary để làm Question 1
	public void ex1q3() {
		System.out
				.println(acc2.department == null ? "Nhân viên này chưa có phòng ban." : "Phòng của nhân viên này là: " +

						acc2.department.name);
	}

	/*
	 * Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của account thứ
	 * 1 Nếu Position = Dev thì in ra text "Đây là Developer" Nếu không phải thì in
	 * ra text "Người này không phải là Developer"
	 */
	public void ex1q4() {

		System.out.println(
				acc1.position.name.toString() == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
	}

	/*
	 * Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số
	 * lượng account = 1 thì in ra "Nhóm có một thành viên" Nếu số lượng account = 2
	 * thì in ra "Nhóm có hai thành viên" Nếu số lượng account = 3 thì in ra
	 * "Nhóm có ba thành viên" Còn lại in ra "Nhóm có nhiều thành viên"
	 */
	public void ex1q5() {
		int CountAccInGroup = gr1.accounts.length;
		switch (CountAccInGroup) {
		case 1:
			System.out.println("Nhóm có 1 thành viên");
			break;

		case 2:
			System.out.println("Nhóm có 2 thành viên");
			break;

		case 3:
			System.out.println("Nhóm có 3 thành viên");
			break;

		default:
			System.out.println("Nhóm có nhiều thành viên");
		}
	}

	// Sử dụng switch case để làm lại Question 2
	public void ex1q6() {
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else {

			switch (acc2.groups.length) {
			case 1:
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;

			case 2:
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				break;

			case 3:
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

			}
		}
	}

	// Sử dụng switch case để làm lại Question 4
	public void ex1q7() {
		String namePosoition = acc1.position.name.toString();
		switch (namePosoition) {
		case "Dev":
			System.out.println("Đây là developer");
			break;
		default:
			System.out.println("Người này không phải developer");
			break;
		}
	}

	// In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
	public void ex1q8() {
		Account[] accInf = { acc1, acc2, acc3 };
		for (Account account : accInf) {
			System.out.println("AccountID: " + account.id + " Email: " +

					account.email + " Name: " + account.fullName);
		}
	}

	// In ra thông tin các phòng ban bao gồm: id và name
	public void ex1q9() {
		Department[] depInf = { dp1, dp2, dp3 };
		for (Department department : depInf) {
			System.out.println("DepartmentID: " + department.id + " Name: " + department.name);
		}
	}

	/*
	 * In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
	 * theo định dạng như sau: Thông tin account thứ 1 là: Email:
	 * NguyenVanA@gmail.com Full name: Nguyễn Văn A Phòng ban: Sale Thông tin
	 * account thứ 2 là: Email: NguyenVanB@gmail.com Full name: Nguyễn Văn B Phòng
	 * ban: Marketting
	 */

	public void ex1q10() {
		Account[] accInf1 = { acc1, acc2 };
		for (int i = 0; i < accInf1.length; i++) {
			System.out.println("Thông tin account thứ " + accInf1[i].id + " là:");
			System.out.println("Email: " + accInf1[i].email);
			System.out.println("Full name: " + accInf1[i].fullName);
			System.out.println("Phòng ban: " + accInf1[i].department.name);

		}
	}

	/*
	 * In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau: Thông
	 * tin department thứ 1 là: Id: 1 Name: Sale Thông tin department thứ 2 là: Id:
	 * 2 Name: Marketing
	 */
	public void ex1q11() {
		Department[] depInf1 = { dp1, dp2, dp3 };
		for (int i = 0; i < depInf1.length; i++) {
			System.out.println("Thông tin department thứ " + depInf1[i] + " là:");
			System.out.println("Id: " + depInf1[i].id);
			System.out.println("Name: " + depInf1[i].name);
		}
	}

	// Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
	public void ex1q12() {
		Department[] depInf2 = { dp1, dp2, dp3 };
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + depInf2[i] + "là:");
			System.out.println("Id: " + depInf2[i].id);
			System.out.println("Name: " + depInf2[i].name);
		}
	}

	// In ra thông tin tất cả các account ngoại trừ account thứ 2
	public void ex1q13() {
		Account[] accInf3 = { acc1, acc2, acc3 };

		for (int i = 0; i < accInf3.length; i++) {
			if (i == 1) {
				continue;
			}
			System.out.println(i);
			System.out.println("Thông tin account thứ " + accInf3[i].getId() + " là:");
			System.out.println("Email: " + accInf3[i].email);
			System.out.println("Full name: " + accInf3[i].fullName);
			System.out.println("Phòng ban: " + accInf3[i].department.name);
			System.out.println("----------------");

		}
	}

	public void ex1q14() {
		Account[] accInf4 = { acc1, acc2, acc3 };
		for (int j = 0; j < accInf4.length; j++) {
			if (accInf4[j].id < 4) {
				System.out.println("Thông tin account thứ " + (j + 1) + " là:");
				System.out.println("Email: " + accInf4[j].email);
				System.out.println("Full name: " + accInf4[j].fullName);
				System.out.println("Phòng ban: " + accInf4[j].department.name);

			}
		}
	}

	// In ra các số chẵn nhỏ hơn hoặc bằng 20
	public void ex1q15() {
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	// Dung while voi question 10
	public void ex1q16() {
		Account[] accInf1 = { acc1, acc2, acc3 };
		int i = 0;
		while (i < accInf1.length) {
			System.out.println("Thông tin account thứ " + accInf1[i].id + " là:");
			System.out.println("Email: " + accInf1[i].email);
			System.out.println("Full name: " + accInf1[i].fullName);
			System.out.println("Phòng ban: " + accInf1[i].department.name);
			i++;
		}

	}

	// Dung do while voi question 10
	public void ex1q17() {
		Account[] accInf1 = { acc1, acc2, acc3 };
		int i = 0;
		do {
			System.out.println("Thông tin account thứ " + accInf1[i].id + "là:");
			System.out.println("Email: " + accInf1[i].email);
			System.out.println("Full name: " + accInf1[i].fullName);
			System.out.println("Phòng ban: " + accInf1[i].department.name);
			i++;
		} while (i < accInf1.length);
	}

	// Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
	public void ex2q1() {
		int i = 5;
		System.out.printf("%d%n", i);

	}

//	Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
	// thực đó chỉ bao gồm 4 số đằng sau
	public void ex2q3() {
		float a = 5.567098f;
		System.out.printf("%5.4f%n", a);
	}

//	Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//	dạng như sau:
//	Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//	Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
	public void ex2q4() {
		String s = "Nguyễn Văn A";
		System.out.printf("Tên tôi là " + s + " và tôi đang độc thân ");
	}

	public void ex2q15() {
		String date = DateUtil.dateToStr(new Date(), "yyyy-MM-dd");
		System.out.println(date);
	}

	public void q2() {
		int[] numbers;
		System.out.println("Nhap vao so luong phan tu cua mang: ");
		int n = ScannerUtil.scanInt();

		// khoi tao mang voi n phan tu;
		numbers = new int[n];

		// vong for nhap du lieu vao mang
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("Nhap vao phan tu thu %d => numbers[%d] = ", i + 1, i);
			numbers[i] = ScannerUtil.scanInt();
		}

		System.out.println("---- Mang vua nhap la ------");
		// System.out.println(Arrays.toString(numbers));
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("numbers[%d] = %d \n", i, numbers[i]);
		}
	}

	// In ra ngau nhien 1 so nguyen
	public void ex4q1() {
		Random random = new Random();
		int n = random.nextInt();
		System.out.println("Số ngẫu nhiên: " + n);
	}

	// Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên
	// ra tên của 1 bạn
	public void ex4q3() {
		Random random = new Random();
		String[] NameArr = { "A", "B", "D", "E", "F" };
		int i = random.nextInt(NameArr.length);
		System.out.println("Tên ngẫu nhiên 1 bạn trong lớp: " + NameArr[i]);
	}

	// Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
	public void ex5q1() {
		System.out.println("Nhập vào 3 số nguyên");
		System.out.println("Nhập vào số 1: ");
		int a = ScannerUtil.scanInt();
		System.out.println("Nhập vào số 2: ");
		int b = ScannerUtil.scanInt();
		System.out.println("Nhập vào số 3: ");
		int c = ScannerUtil.scanInt();
		System.out.println("Bạn vừa nhập vào các số: " + a + " " + b + " " + c);
	}

	// Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
	public void ex5q3() {
		System.out.println("Mời bạn nhập vào Họ: ");
		String s1 = ScannerUtil.scanString();
		System.out.println("Mời bạn nhập vào Tên: ");
		String s2 = ScannerUtil.scanString();
		System.out.println("Fullname của bạn là:" + s1 + " " + s2);
	}

	// Viết lệnh cho phép người dùng tạo department (viết thành method)
	public static void ex5q6() {
		System.out.println("Nhập vào thông tin Department cân tạo: ");

		Department dep = new Department();
		System.out.println("Nhập ID: ");
		dep.id = ScannerUtil.scanInt();
		System.out.println("Nhập Name: ");
		dep.name = ScannerUtil.scanString();
		System.out.println("Thông tin Department vừa nhập, ID: " + dep.id + " Name: " + dep.name);
	}

//	Viết lệnh cho phép người dùng tạo account (viết thành method)
//	Đối với property Position, Người dùng nhập vào 1 2 3 4 và vào
//	chương trình sẽ chuyển thành Position.Dev, Position.Test,
//	Position.ScrumMaster, Position.PM
	public static void ex5q5() {
		System.out.println("Mời bạn nhập vào thông tin account cân tạo:");
		Account acc = new Account();
		System.out.println("Nhập ID: ");
		acc.id = ScannerUtil.scanInt();
		System.out.println("Nhập email: ");
		acc.email = ScannerUtil.scanString();
		System.out.println("Nhập userName: ");
		acc.userName = ScannerUtil.scanString();
		System.out.println("Nhập fullName: ");
		acc.fullName = ScannerUtil.scanString();
		System.out
				.println("Nhập position (Nhập các số từ 1 đến 4 tương ứng với: 1.Dev, 2.Test, 3.Scrum_Master, 4.PM): ");

		int position = ScannerUtil.scanInt();
		switch (position) {
		case 1:
			Position pos1 = new Position(1, PositionName.Dev);
			acc.position = pos1;
			break;
		case 2:
			Position pos2 = new Position(2, PositionName.Test);
			acc.position = pos2;
			break;

		case 3:
			Position pos3 = new Position(3, PositionName.PM);
			acc.position = pos3;
			break;

		case 4:
			Position pos4 = new Position(4, PositionName.Scrum_Master);
			acc.position = pos4;
			break;

		}
		System.out.println("Thông tin Acc vừa nhập, ID: " + acc.id + " Email: " + acc.email + " UserName: "
				+ acc.userName + " FullName: " + acc.fullName + " Position: " + acc.position.name);
	}

//	Viết chương trình thực hiện theo flow sau:
//		Bước 1:
//		Chương trình in ra text "mời bạn nhập vào chức năng muốn sử
//		dụng"
//		Bước 2:
//		Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
//		Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
//		department
//		Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
//		lại" và quay trở lại bước 1
	public static void ex5q8() {
		int choose;
		while (true) {
			System.out.println("Mời bạn chọn chức năng: 1. Tạo Account, 2. Tạo Department");

			choose = ScannerUtil.scanInt();
			if (choose == 1 || choose == 2) {
				switch (choose) {
				case 1:
					ex5q5();
					break;
				case 2:
					ex5q6();
					break;
				}
				return;
			} else {
				System.out.println("Nhập lại: ");
			}
		}
	}
}
