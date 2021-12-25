package entity;
import java.time.LocalDate;

public class Question {
	public int id;
	public String content;
	public TypeQuestion type;
	public Account creator;
	public LocalDate createDate;
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
	public TypeQuestion getType() {
		return type;
	}
	public void setType(TypeQuestion type) {
		this.type = type;
	}
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", type=" + type + ", creator=" + creator
				+ ", createDate=" + createDate + "]";
	}
	
}
