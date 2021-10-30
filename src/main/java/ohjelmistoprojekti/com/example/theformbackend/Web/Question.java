package ohjelmistoprojekti.com.example.theformbackend.Web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Question {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long questionId;
	private String question;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="questionaryId")
	private Questionary questionary;
	
	public Question() {
		super();
	}
	public Question(String question, Questionary questionary) {
		super();
		this.question=question;
		this.questionary=questionary;
	
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", questionary=" + questionary + "]";
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Questionary getQuestionary() {
		return questionary;
	}
	public void setQuestionary(Questionary questionary) {
		this.questionary = questionary;
	}
	
}
	