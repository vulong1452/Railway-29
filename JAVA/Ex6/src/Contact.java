
public class Contact {
	public Contact(String number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	private String number;
	private String name;

	@Override
	public String toString() {
		return " number =" + number + ", name =" + name ;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
