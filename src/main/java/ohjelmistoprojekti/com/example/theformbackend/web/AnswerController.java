package ohjelmistoprojekti.com.example.theformbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ohjelmistoprojekti.com.example.theformbackend.domain.AnswerRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionnaryRepository;

@Controller
public class AnswerController {

	// Spring-alusta luo sovelluksen käynnistyessä AnswerRepository-rajapintaa toteuttavan luokan 
	// olion ja kytkee olion AnswerController-luokasta luodun olion attribuuttiolioksi,
	// jotta on olemassa repository olio jonka metodeja voidaan kutsua
	@Autowired
	private AnswerRepository awrrepository;
	@Autowired
	private QuestionnaryRepository qryrepository;
	@Autowired 
	private QuestionRepository qrepository;
	
	
}
