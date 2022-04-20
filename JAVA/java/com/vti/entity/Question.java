package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Question",catalog = "testing_system_1")
public class Question {
	@Column(name = "QuestionID")
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Content", length = 50, nullable = false, unique = true)
	private String content;

	@ManyToMany(mappedBy = "listQs")	
	private List<Exam> listExam;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Exam> getListExam() {
		return listExam;
	}

	public void setListExam(List<Exam> listExam) {
		this.listExam = listExam;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + "]";
	}
	
}
