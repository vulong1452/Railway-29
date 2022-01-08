package ex6.q2.q3;

public abstract class User {
	public User(String name, double salaryRatio) {
		super();
		this.name = name;
		this.salaryRatio = salaryRatio;
	}

	private String name;
	Double salaryRatio;



	public abstract Double calculatePay();

	public void displayInfor() {
		System.out.println("Name: " + name + "Ration Salary: " + salaryRatio + "Lương đưuọc nhận: " + calculatePay());
	}
}
