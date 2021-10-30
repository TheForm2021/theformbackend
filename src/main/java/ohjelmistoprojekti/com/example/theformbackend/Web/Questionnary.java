package ohjelmistoprojekti.com.example.theformbackend.Web;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Questionnary {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long questionnaryId;
	private String header;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="questionnary")
	private List<Question> questions;
	
	public Questionnary() {
		super();
	
	}
	public Questionnary(String header, String description) {
		super();
		this.header=header;
		this.description=description;
	
}
public Long getQuestionnaryId() {
	return questionnaryId;
}
public void setQuestionnaryId(Long questionnaryId) {
	this.questionnaryId = questionnaryId;
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
	return "Questionnary [questionnaryId=" + questionnaryId + ", header=" + header + ", description=" + description;

}
}