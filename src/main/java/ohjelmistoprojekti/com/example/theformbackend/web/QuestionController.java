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
import ohjelmistoprojekti.com.example.theformbackend.domain.Option;
import ohjelmistoprojekti.com.example.theformbackend.domain.OptionRepository;
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
	@Autowired
	private OptionRepository orepository;
	
	//Uuden kysymyksen lisäyslomake.
	//Lomake tulee oikein näkyviin ja sen alle listaantuu ko kyselyID:n alla olevat kysymykset
	@GetMapping("/addquestion/{id}")
	public String getQuestionForm(Model model,@PathVariable("id")Long questionnaryId, Type type) { // pathvariable eristää idn numeron urlista
		Question question= new Question();
		Option option= new Option();
		model.addAttribute("questionnaryid", questionnaryId);
		model.addAttribute("questionnaryText",qryrepository.findById(questionnaryId).get().getHeader());
		model.addAttribute("question", question);
		model.addAttribute("questions", qryrepository.findById(questionnaryId).get().getQuestions());
		model.addAttribute("types", trepository.findAll());
		model.addAttribute("type", type);
		model.addAttribute("option", option);
		model.addAttribute("options", orepository.findAll());
		return "newquestion";
	}
			
	//Uuden kysymyksen tallennus TOIMII !!!
	@PostMapping("/savequestion")
	public String saveQuestions(@ModelAttribute Question question, @ModelAttribute("questionnaryid") Long id) {	
	
		Questionnary qry=qryrepository.findById(id).get();
		question.setQuestionnary(qry);
		qrepository.save(question);
		
		return "redirect:/newoption/"+question.getQuestionId();
	
	}
	@GetMapping("/newoption/{id}")
	public String getOptionForm(Model model,@PathVariable("id") Long questionId) {
		Option option= new Option();
		model.addAttribute("questionnary", qrepository.findById(questionId).get().getQuestionnary());
		model.addAttribute("questionId", questionId);
		model.addAttribute("option", option);
		model.addAttribute("options", qrepository.findById(questionId).get().getOptions());
		model.addAttribute("questionText",qrepository.findById(questionId).get().getQuestionText());
		return "newoption";
	}
	@PostMapping("/saveoption")
	public String saveOptions(@ModelAttribute Option option, @ModelAttribute("questionId") Long id) {
		Question question= qrepository.findById(id).get();
		option.setQuestion(question);
		orepository.save(option);
		
		
		
		return "redirect:/newoption/"+option.getQuestion().getQuestionId();
			
}
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id")Long optionId, Model model) {
		Question question= orepository.findById(optionId).get().getQuestion();
		orepository.deleteById(optionId);
		return "redirect:/newoption/"+question.getQuestionId();
	}
	
}
