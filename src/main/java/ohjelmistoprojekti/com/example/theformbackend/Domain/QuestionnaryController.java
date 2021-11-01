package ohjelmistoprojekti.com.example.theformbackend.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ohjelmistoprojekti.com.example.theformbackend.Web.Question;
import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.Web.Questionnary;
//import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionnaryRepository;

@Controller
public class QuestionnaryController {
	
	@Autowired
	private QuestionnaryRepository qryrepository;
	
	@Autowired 
	QuestionRepository qrepository;
	
	//Listaa kaikki kyselyt. Tää toimii
	@GetMapping("questionnarylist")
	public String questionnarylist(Model model) {
		model.addAttribute("questionnaries", qryrepository.findAll());
		return "questionnarylist";
	}
	//Uuden kyselyn lisäyslomake, toimii
		@GetMapping("newquestionnary")
		public String addQuestionnaryForm(Model model) {
			model.addAttribute("questionnary", new Questionnary());
			return "newquestionnary";
		}

		//Uuden kyselyn tallennus, toimii
		@PostMapping("savequestionnary")
		public String saveQuestionnary(@ModelAttribute("questionnary") Questionnary questionnary, Model model){
			
			qryrepository.save(questionnary);
			
			return "redirect:questionnarylist";
		
		}
		//Uuden kysymyksen lisäyslomake.
		//Lomake tulee oikein näkyviin ja sen alle listaantuu ko kyselyID:n alla olevat kysymykset
	@GetMapping("addquestion/{id}")
	public String getQuestionForm(Model model,@PathVariable("id")Long id) {
		
		model.addAttribute("question", new Question(qryrepository.findById(id).get()));
		//model.addAttribute("questionnary",qryrepository.findById(id).get());
		model.addAttribute("questions", qryrepository.findById(id).get().getQuestions());
		
		return "newquestion";
	}
			
		//Uuden kysymyksen tallennus EI TOIMI PRKL!!!
	@PostMapping("savequestion")
			public String saveQuestions(@ModelAttribute("question")Question question) {	
		
			qrepository.save(question);
		
			
			return "redirect: newquestion";
	
			
			
			}
			
			
			
		}


