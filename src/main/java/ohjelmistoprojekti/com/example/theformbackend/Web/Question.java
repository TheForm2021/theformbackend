package ohjelmistoprojekti.com.example.theformbackend.Web;

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
	private String question;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="questionnaryId")
	private Questionnary questionnary;
	
	public Question() {
		super();
		
	}
	public Question(String question, Questionnary questionnary) {
		super();
		this.question=question;
		this.questionnary=questionnary;
	
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", questionary=" + questionnary + "]";
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
	public Questionnary getQuestionnary() {
		return questionnary;
	}
	public void setQuestionnary(Questionnary questionnary) {
		this.questionnary = questionnary;
	}
	
}
	