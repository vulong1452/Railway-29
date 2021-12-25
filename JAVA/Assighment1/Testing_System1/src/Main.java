import entity.Account;
import entity.Department;
import entity.Group;
import entity.Position;
import entity.Position.PositionName;

public class Main {
	public static void main(String[] args) {
	/*	// In bằng hàm khởi tạo
		Department dp1 = new Department(1, "phong 1");

		System.out.println(dp1.toString());

		// In bằng set
		Department dp2 = new Department();
		dp2.setId(2);
		dp2.setName("Phong Kinh Doanh");

		dp2.printDepartment();

		Department dp3 = new Department();
		dp3.setId(3);
		dp3.setName("Phong Nhan Su");

		dp3.printDepartment();

		System.out.println("----------------");

		Position ps1 = new Position();
		ps1.setId(1);
		ps1.name = PositionName.Dev;

		ps1.printPosition();

		Position ps2 = new Position();
		ps2.setId(1);
		ps2.name = PositionName.Test;

		ps2.printPosition();

		Position ps3 = new Position();
		ps3.setId(1);
		ps3.name = PositionName.PM;

		ps3.printPosition();

		System.out.println("----------------");

		Account acc1 = new Account();
		acc1.setId(1);
		acc1.setEmail("long@gmail.com");
		acc1.setUserName("long1");
		acc1.setFullName("VuLong");
		acc1.setDepartment(dp1);
		acc1.setPosition(ps1);
		acc1.setCreateDate(null);

		acc1.printAccount();

		System.out.println("----------------");

		Group gr1 = new Group();
		gr1.setId(1);
		gr1.setName("Nhóm 1");
		gr1.setCreator(acc1);
		gr1.setCreateDate(null);

		gr1.printGroup();*/
		
		
		/*
		int a[] = { 10, 20, 30, 40, 50 };
		System.out.println("-------For---------");
		// vòng lặp for
		for (int x = 0; x < a.length; x++) {

			System.out.printf("x = %d , a[%d] = %d \n", x, x, a[x]);
		}
		System.out.println("-------foreach---------");
		// foreach : chạy hết mảng
		int i = 0;
		for (int t : a) {
			System.out.printf("i =%d , t= %d \n", i, t);
			i++;
		}
		System.out.println("-------While---------");
		// Vòng lặp While
		int index = 0;
		while (index < a.length) {
			System.out.printf("index = %d, a[%d] = %d \n", index, index, a[index]);
			index++;
		}
		System.out.println("-------Do While---------");
		// vòng lặp Do While : chạy 1 lần do rồi chạy tới while
		int y = 0;
		do {
			System.out.printf("index = %d\n",y);
			y++;
			
		} while (y < a.length);
		System.out.println("----------------");
		int c = 0;
		System.out.println(c == 0?"Hello c":"Good bye");*/
		
	}

}
