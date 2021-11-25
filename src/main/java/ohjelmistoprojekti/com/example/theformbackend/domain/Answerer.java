package ohjelmistoprojekti.com.example.theformbackend.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Answerer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answererId;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="answerer")
	private List<Answer> answers;
	
	public Answerer () {
		super();
	}

	public Long getAnswererId() {
		return answererId;
	}

	public void setAnswererId(Long answererId) {
		this.answererId = answererId;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Answerer [answererId=" + answererId + "]";
	}


	
	
	
	
}
