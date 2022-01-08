package ex6.q2.q3;

public class Waiter extends User {

	public Waiter(String name, double salaryRatio) {
		super(name, salaryRatio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calculatePay() {

		return salaryRatio * 220;
	}

}
