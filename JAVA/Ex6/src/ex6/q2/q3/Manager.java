package ex6.q2.q3;

public class Manager extends User {

	public Manager(String name, double salaryRatio) {
		super(name, salaryRatio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calculatePay() {

		return salaryRatio * 520;
	}

}
