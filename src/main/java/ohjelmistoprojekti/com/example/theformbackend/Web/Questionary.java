package ohjelmistoprojekti.com.example.theformbackend.Web;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Questionary {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long questionaryId;
	private String header;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="questionary")
	private List<Question> questions;
	
	public Questionary() {
		super();
	
	}
	public Questionary(String header, String description) {
		super();
		this.header=header;
		this.description=description;
	
}
public Long getQuestionaryId() {
	return questionaryId;
}
public void setQuestionaryId(Long questionaryId) {
	this.questionaryId = questionaryId;
}
public String getHeader() {
	return header;
}
public void setHeader(String header) {
	this.header = header;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public List<Question> getQuestions() {
	return questions;
}
public void setQuestions(List<Question> questions) {
	this.questions = questions;
	
}
@Override
public String toString() {
	return "Questionary [questionaryId=" + questionaryId + ", header=" + header + ", description=" + description;

}
}