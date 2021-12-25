package entity;

public class Department {

	// thuộc tính
	public int id;
	public String name;

	// phương thức in ra thông tin đối tượng department
	public void printDepartment() {
		System.out.println("Thông tin phòng ban: " + id + ",tên :" + name);
	}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Department() {

	}

	// để trả về giá trị id
	public int getId() {
		return id;
	}

	// cài đặt giá trị id
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
