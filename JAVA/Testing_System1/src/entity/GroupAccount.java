package entity;

import java.time.LocalDate;

public class GroupAccount {
	public Group Group;
	public Account Account;
	public LocalDate joinDate;
	
	public Group getIdGroup() {
		return Group;
	}
	public void setIdGroup(Group Group) {
		this.Group = Group;
	}
	public Account getIdAccount() {
		return Account;
	}
	public void setIdAccount(Account Account) {
		this.Account = Account;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "GroupAccount [idGroup=" + Group + ", idAccount=" + Account + ", joinDate=" + joinDate + "]";
	}
	
}
