package ohjelmistoprojekti.com.example.theformbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Question;
import ohjelmistoprojekti.com.example.theformbackend.domain.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionnaryRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Type;
import ohjelmistoprojekti.com.example.theformbackend.domain.TypeRepository;


@Controller
public class QuestionController {
	@Autowired
	private QuestionnaryRepository qryrepository;
	@Autowired 
	private QuestionRepository qrepository;
	@Autowired 
	private TypeRepository trepository;
	
	
	//Uuden kysymyksen lisäyslomake.
	//Lomake tulee oikein näkyviin ja sen alle listaantuu ko kyselyID:n alla olevat kysymykset
	@GetMapping("/addquestion/{id}")
	public String getQuestionForm(Model model,@PathVariable("id")Long questionnaryId, @RequestParam("typeId")Long typeId) { // pathvariable eristää idn numeron urlista
		Question question= new Question();
	
		model.addAttribute("questionnaryid", questionnaryId);
		model.addAttribute("question", question);
		model.addAttribute("questions", qryrepository.findById(questionnaryId).get().getQuestions());
		model.addAttribute("types", trepository.findAll());
		model.addAttribute("type", trepository.findById(typeId));
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


