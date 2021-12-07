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
	//@JsonIgnore
	@JoinColumn(name="questionId")
	Question question;
	
	@ManyToOne
	//@JsonIgnore
	@JsonIgnoreProperties("answers")
	@JoinColumn(name="answererId")
	private Answerer answerer;
	

	public Answer() {
		super();
	}
	
	public Answer(String answerText, Question question, Answerer answerer) {
		this.answerText=answerText;
		this.question=question;
		this.answerer=answerer;
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
	
	public Answerer getAnswerer() {
		return answerer;
	}

	public void setAnswerer(Answerer answerer) {
		this.answerer = answerer;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerText=" + answerText + ", question=" + question + ", answerer=" + answerer + "]";
	}
	
	

}
