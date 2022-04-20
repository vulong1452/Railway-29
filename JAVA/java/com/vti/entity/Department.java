package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Department")
public class Department {
	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private int id;

	@Column(name = "DepartmentName", length = 50, nullable = false, unique = true)
	private String dPname;

	@OneToMany
	@Cascade(value= {org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
	@JoinColumn(name = "DepartmentID",referencedColumnName = "DepartmentID")
	private List<Account> accounts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdPname() {
		return dPname;
	}

	public void setdPname(String dPname) {
		this.dPname = dPname;
	}

	public Department() {

	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dPname=" + dPname + ", accounts=" + accounts + "]";
	}

	
	
}
