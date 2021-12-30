package entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Account {
	public int id;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public LocalDate createDate;
	public Group[] groups;

	public void printAccount() {
		System.out.println("Thông tin tài khoản : " + id + " Email: " +

				email + " UserName: " + userName + " FullName: " + fullName + " Department: " +

				department.name + " Position: " + position.name + " Group: " + "CreateDate: " + createDate);
	}

	public Account(int id, String userName, Department department, Position position) {
		super();
		this.id = id;
		this.userName = userName;
		this.department = department;
		this.position = position;
	}
	

	public Account(String email, String userName, String fullName, LocalDate createDate) {
		super();
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.createDate = createDate;
	}

	public Account(int id, String email, String userName, String fullName, Department department, Position position
			) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		
	}

	public Account(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
				+ ", department=" + department + ", position=" + position + ", createDate=" + createDate + ", groups="
				+ Arrays.toString(getGroups())+ "]";
	}

	

}
