package ohjelmistoprojekti.com.example.theformbackend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



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
	
	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name="typeId")
	private Type type;
	
	// kysymykseen voi liittyä monia vaihtoehtoja
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	List<Option> options;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
	List<Answer> answers;
	
	public Question() {
		super();
		
	}
	public Question(String questionText, Questionnary questionnary, Type type) {
		super();
		this.questionText=questionText;
		this.questionnary=questionnary;
		this.type=type;
	
	}
	//public Question(Questionnary questionnary) {
	//	super();
	//	this.questionnary=questionnary;
	//}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", questionary=" + questionnary + ", type=" + type + "]";
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
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public List<Option> getOptions() {
		
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	

	
}
	