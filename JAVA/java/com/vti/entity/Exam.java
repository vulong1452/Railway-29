package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Exam", catalog = "testing_system_1")
public class Exam {
	@Column(name = "ExamID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Title", length = 50, nullable = false, unique = true)
	private String title;

	@ManyToMany
	@JoinTable(name = "ExamQuestion",
	joinColumns = { @JoinColumn(name = "ExamID") },
	inverseJoinColumns = {@JoinColumn(name = "QuestionID") })
	private List<Question> listQs;

	@Transient
	private String info;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

	public List<Question> getListQs() {
		return listQs;
	}

	public void setListQs(List<Question> listQs) {
		this.listQs = listQs;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", title=" + title + "]";
	}

}
