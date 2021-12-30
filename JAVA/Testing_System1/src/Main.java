import java.util.InputMismatchException;
import java.util.Scanner;

import entity.TestingSystem1;
import utils.ScannerUtil;

public class Main {
	public static void main(String[] args) {

		int input  = 0;
		TestingSystem1 tSystem1 = new TestingSystem1();

		while (input != 100) {
			
			System.out.println("Nhap vao cau hoi : (100 - thoat)");
			input = ScannerUtil.scanInt();
			switch (input) {
			case 1: 
				System.out.println("----Cau tra loi 1.----");
				tSystem1.ex1q1();
				break;
			case 2 :
				System.out.println("----Cau tra loi 2.----");
				tSystem1.ex1q2();
				break;
			case 3 :
				System.out.println("----Cau tra loi 3.----");
				tSystem1.ex1q3();
				break;
			case 4 :
				System.out.println("----Cau tra loi 4.----");
				tSystem1.ex1q4();
				break;
			case 5 :
				System.out.println("----Cau tra loi 5.----");
				tSystem1.ex1q5();
				break;
			case 6 :
				System.out.println("----Cau tra loi 6.----");
				tSystem1.ex1q6();
				break;
			case 100 :
				System.out.println("Thoat chuong trinh");
				break;
			}
			System.out.println("-------------------");
		}
		
		
	}
}