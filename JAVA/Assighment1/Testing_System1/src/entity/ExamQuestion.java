package entity;

public class ExamQuestion {
	public Exam exam;
	public Question question;
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "ExamQuestion [exam=" + exam + ", question=" + question + "]";
	}
	
}
