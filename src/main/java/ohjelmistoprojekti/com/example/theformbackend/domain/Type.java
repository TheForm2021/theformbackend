package ohjelmistoprojekti.com.example.theformbackend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Type {
	
	// tyyppi voi liittyä moneen eri kysymykseen
	// mutta kysymyksellä voi olla vain yksi tyyppi
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeId;
	private String typeText;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="type")
	private List<Question> questions;
	
	public Type () {
		super();
	}
	
	public Type (String typeText) {
		this.typeText = typeText;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeText=" + typeText + "]";
	}
	
	
	

}
