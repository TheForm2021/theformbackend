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
import ohjelmistoprojekti.com.example.theformbackend.domain.Answerer;
import ohjelmistoprojekti.com.example.theformbackend.domain.AnswererRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Question;
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
	@Autowired
	private AnswererRepository arepository;
	
	
	//REST service to get answers to certain question
	@GetMapping(value="/questions/{questionid}/answers")
	public @ResponseBody List<Answer> findAnswerRest(@PathVariable("questionid")Long id) {
		qrepository.findById(id).get().getAnswers();
		
		return qrepository.findById(id).get().getAnswers();
		
	}
	@PostMapping(value="/answerer")
	public @ResponseBody String saveAnswerer(@RequestBody Answerer answerer) {
		arepository.save(answerer);
		return "redirect:/answers";
		
	}

	
	@PostMapping(value="/answers")
	public @ResponseBody List <Answer> saveRestAnswerList(@RequestBody List<Answer> answers){
		System.out.println(answers);
		
		
		return (List<Answer>) awrrepository.saveAll(answers);
	}
	//lists all questions and answers of certain questionnary
	@GetMapping(value="/questionnaries/{questionnaryId}")
	public @ResponseBody Questionnary findQuestionnaries(@PathVariable ("questionnaryId")Long questionnaryId){
		return qryrepository.findById(questionnaryId).get();
	}
	@GetMapping(value="/answers")
	public @ResponseBody List <Answer> findallAnswersRest(){
	
		return (List<Answer>) awrrepository.findAll();
	}
	
}