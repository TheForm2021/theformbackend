package ohjelmistoprojekti.com.example.theformbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.com.example.theformbackend.domain.Answer;
import ohjelmistoprojekti.com.example.theformbackend.domain.AnswerRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionnaryRepository;

@CrossOrigin
@RestController
public class RestAnswerController {

	// Spring-alusta luo sovelluksen käynnistyessä AnswerRepository-rajapintaa toteuttavan luokan 
	// olion ja kytkee olion AnswerController-luokasta luodun olion attribuuttiolioksi,
	// jotta on olemassa repository olio jonka metodeja voidaan kutsua
	@Autowired
	private AnswerRepository awrrepository;
	@Autowired
	private QuestionnaryRepository qryrepository;
	@Autowired 
	private QuestionRepository qrepository;
	
	
	//REST service to get answers to certain question
	@GetMapping(value="/answers/{id}")
	public @ResponseBody List<Answer> findAnswerRest(@PathVariable("id")Long id) {
		return (List <Answer>)qrepository.findById(id).get().getAnswers();
	}
	//saves answer to repository
	@PostMapping(value="/answers")
	public @ResponseBody Answer saveAnswerRest( @RequestBody Answer answer) {
	//	Question question= qrepository.findById(id).get();
	//	answer.setQuestion(question);
		return awrrepository.save(answer);
	
	}
	//lists all questions and answers of certain questionnary
	@GetMapping(value="/questionnaries/{questionnaryId}")
	public @ResponseBody Questionnary findQuestionnaries(@PathVariable ("questionnaryId")Long questionnaryId){
		return qryrepository.findById(questionnaryId).get();
	}
	
}