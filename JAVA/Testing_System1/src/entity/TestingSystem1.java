package entity;

import java.time.LocalDate;

import entity.Position.PositionName;

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

	public void Ex1q1() {
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
	public void Ex1q2() {
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
	public void Ex1q3() {
		System.out
				.println(acc2.department == null ? "Nhân viên này chưa có phòng ban." : "Phòng của nhân viên này là: " +

						acc2.department.name);
	}

	/*
	 * Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của account thứ
	 * 1 Nếu Position = Dev thì in ra text "Đây là Developer" Nếu không phải thì in
	 * ra text "Người này không phải là Developer"
	 */
	public void Ex1q4() {

		System.out.println(
				acc1.position.name.toString() == "Dev" ? "Đây là Developer" : "Người này không phải là Developer");
	}

	/*
	 * Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số
	 * lượng account = 1 thì in ra "Nhóm có một thành viên" Nếu số lượng account = 2
	 * thì in ra "Nhóm có hai thành viên" Nếu số lượng account = 3 thì in ra
	 * "Nhóm có ba thành viên" Còn lại in ra "Nhóm có nhiều thành viên"
	 */
	public void Ex1q5() {
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
	public void Ex1q6() {
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
	public void Ex1q7() {
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
	public void Ex1q8() {
		Account[] accArray = { acc1, acc2, acc3 };
		for (Account account : accArray) {
			System.out.println("AccountID: " + account.id + " Email: " +

					account.email + " Name: " + account.fullName);
		}
	}

	// In ra thông tin các phòng ban bao gồm: id và name
	public void Ex1q9() {
		Department[] depArray = { dp1, dp2, dp3 };
		for (Department department : depArray) {
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

	public void Ex1q10() {
		Account[] accArray1 = { acc1, acc2 };
		for (int i = 0; i < accArray1.length; i++) {
			System.out.println("Thông tin account thứ " + accArray1[i].id + " là:");
			System.out.println("Email: " + accArray1[i].email);
			System.out.println("Full name: " + accArray1[i].fullName);
			System.out.println("Phòng ban: " + accArray1[i].department.name);

		}
	}

	/*
	 * In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau: Thông
	 * tin department thứ 1 là: Id: 1 Name: Sale Thông tin department thứ 2 là: Id:
	 * 2 Name: Marketing
	 */
	public void Ex1q11() {
		Department[] depArray1 = { dp1, dp2, dp3 };
		for (int i = 0; i < depArray1.length; i++) {
			System.out.println("Thông tin department thứ " + depArray1[i] + " là:");
			System.out.println("Id: " + depArray1[i].id);
			System.out.println("Name: " + depArray1[i].name);
		}
	}

	// Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
	public void Ex1q12() {
		Department[] depArray2 = { dp1, dp2, dp3 };
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + depArray2[i] + "là:");
			System.out.println("Id: " + depArray2[i].id);
			System.out.println("Name: " + depArray2[i].name);
		}
	}

	// In ra thông tin tất cả các account ngoại trừ account thứ 2
	public void Ex1q13() {
		Account[] accArray2 = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray2.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin account thứ " + accArray2[i] + " là:");
				System.out.println("Email: " + accArray2[i].email);
				System.out.println("Full name: " + accArray2[i].fullName);
				System.out.println("Phòng ban: " + accArray2[i].department.name);

			}
		}
	}

	// In ra thông tin tất cả các account có id < 4
	public void Ex1q14() {
		Account[] accArray3 = { acc1, acc2, acc3 };
		for (int i = 0; i < accArray3.length; i++) {
			if (accArray3[i].id < 4) {
				System.out.println("Thông tin account thứ " + accArray3[i] + " là:");
				System.out.println("Email: " + accArray3[i].email);
				System.out.println("Full name: " + accArray3[i].fullName);
				System.out.println("Phòng ban: " + accArray3[i].department.name);

			}
		}
	}

	// In ra các số chẵn nhỏ hơn hoặc bằng 20
	public void Ex1q15() {
		for (int i = 1; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void Ex1() {
		
	}
}
