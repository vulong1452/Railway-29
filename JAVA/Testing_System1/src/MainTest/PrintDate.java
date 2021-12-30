package MainTest;

import java.util.Random;

public class PrintDate {

	public static void main(String[] args) {
		Random random = new Random();
		//1,2,3,4,5,6
		System.out.println(random.nextInt(21) +20);
		//a -> b
		//nextInt(b-1+1) + a;
	}

}
