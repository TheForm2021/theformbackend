package ohjelmistoprojekti.com.example.theformbackend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ohjelmistoprojekti.com.example.theformbackend.domain.Question;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionnaryRepository;

@CrossOrigin
@Controller
public class QuestionnaryController {
	
	// Spring-alusta luo sovelluksen käynnistyessä QuestionnaryRepository-rajapintaa toteuttavan luokan olion
	// ja kytkee olion QuestionnaryController-luokasta luodun olion attribuuttiolioksi, jotta on 
	// repository olio jonka metodeja voidaan kutsua
	@Autowired
	private QuestionnaryRepository qryrepository;
	
	@Autowired 
	QuestionRepository qrepository;
	
	//Listaa kaikki kyselyt. Tää toimii
	@GetMapping("/questionnarylist")
	public String questionnarylist(Model model) {
		model.addAttribute("questionnaries", qryrepository.findAll());
		return "questionnarylist";
	}
	
	//Uuden kyselyn lisäyslomake, toimii
	@GetMapping("/newquestionnary")
	public String addQuestionnaryForm(Model model) {
		model.addAttribute("questionnary", new Questionnary());
		return "newquestionnary";
	}

	//Uuden kyselyn tallennus, toimii
	@PostMapping("/savequestionnary")
	public String saveQuestionnary(@ModelAttribute("questionnary") Questionnary questionnary, Model model){
		qryrepository.save(questionnary);
		return "redirect:questionnarylist";
	}
		
	//Uuden kysymyksen lisäyslomake.
	//Lomake tulee oikein näkyviin ja sen alle listaantuu ko kyselyID:n alla olevat kysymykset
	@GetMapping("/addquestion/{id}")
	public String getQuestionForm(Model model,@PathVariable("id")Long questionnaryId) { // pathvariable eristää idn numeron urlista
		Question question= new Question();
		
		model.addAttribute("questionnaryid", questionnaryId);
		model.addAttribute("question", question);
		model.addAttribute("questions", qryrepository.findById(questionnaryId).get().getQuestions());
		
		return "newquestion";
	}
			
	//Uuden kysymyksen tallennus EI TOIMI !!!
	@PostMapping("/savequestion")
	public String saveQuestions(@ModelAttribute Question question, @ModelAttribute("questionnaryid") Long id) {	
	
		Questionnary qry=qryrepository.findById(id).get();
		question.setQuestionnary(qry);
		qrepository.save(question);
		
		return "redirect:addquestion/"+qry.getQuestionnaryId();
	
	}
			
			
			
}


