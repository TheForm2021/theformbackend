package ohjelmistoprojekti.com.example.theformbackend.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Question {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long questionId;
	private String questionText;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="questionnaryId")
	private Questionnary questionnary;
	
	public Question() {
		super();
		
	}
	public Question(String questionText, Questionnary questionnary) {
		super();
		this.questionText=questionText;
		this.questionnary=questionnary;
	
	}
	//public Question(Questionnary questionnary) {
	//	super();
	//	this.questionnary=questionnary;
	//}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", questionary=" + questionnary + "]";
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public Questionnary getQuestionnary() {
		return questionnary;
	}
	public void setQuestionnary(Questionnary questionnary) {
		this.questionnary = questionnary;
	}
	
}
	