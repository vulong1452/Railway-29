package com.vti.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scanner = new Scanner(System.in);

	// nhan gia tri so nguyen tu ban phim
	public static int scanInt() {
		int result = 0;
		boolean stop = false;

		while (stop == false) {
			try {
				result = scanner.nextInt();
				scanner.nextLine();
				stop = true;
			} catch (InputMismatchException e) {

				System.err.println("Du lieu nhap vao khong phai la so ");
				System.out.println("Moi nhap lai :");
				scanner.nextLine();
			}
		}

		return result;
	}

	public static float scanFloat() {
		float result = 0;
		boolean stop = false;

		while (stop == false) {
			try {
				result = scanner.nextFloat();
				scanner.nextLine();
				stop = true;
			} catch (InputMismatchException e) {

				System.err.println("Du lieu nhap vao khong phai la so ");
				System.out.println("Moi nhap lai :");
				scanner.nextLine();
			}
		}

		return result;
	}
	
	public static String scanString() {
		return scanner.nextLine();
	}
}
