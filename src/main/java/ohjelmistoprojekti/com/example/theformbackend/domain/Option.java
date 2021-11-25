package ohjelmistoprojekti.com.example.theformbackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Option {

	// yhdellä kysymyksellä voi olla monta vaihtoehtoa
	// mutta vaihtoehto kuuluu vaan yhteen tiettyyn kysymykseen
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long optionId;
	private String optionText;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="questionId")
	private Question question;
	
	public Option () {
		super();
	}
	
	
	public Option (String optionText, Question question) {
		super ();
		this.optionText = optionText;
		this.question = question;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", optionText=" + optionText + ", question=" + question + "]";
	}
	
	
	
	
	
}
