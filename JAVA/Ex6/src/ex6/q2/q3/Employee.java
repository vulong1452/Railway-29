package ex6.q2.q3;

public class Employee extends User {

	public Employee(String name, double salaryRatio) {
		super(name, salaryRatio);

	}

	@Override
	public Double calculatePay() {
		return salaryRatio * 420;
	}

}
