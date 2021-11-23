package ohjelmistoprojekti.com.example.theformbackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Answer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerId;
	private String answerText;
	
	@ManyToOne
	@JsonIgnoreProperties("answers")
	@JoinColumn(name="questionId")
	Question question;
	

	public Answer() {
		super();
	}
	public Answer(String answerText, Question question) {
		this.answerText=answerText;
		this.question=question;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerText=" + answerText + ", question=" + question + "]";
	}
	
	

}
