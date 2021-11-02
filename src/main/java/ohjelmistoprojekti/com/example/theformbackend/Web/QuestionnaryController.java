package ohjelmistoprojekti.com.example.theformbackend.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ohjelmistoprojekti.com.example.theformbackend.Domain.Question;
import ohjelmistoprojekti.com.example.theformbackend.Domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.Domain.Questionnary;
//import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.Domain.QuestionnaryRepository;

@CrossOrigin
@Controller
public class QuestionnaryController {
	
	@Autowired
	private QuestionnaryRepository qryrepository;
	
	@Autowired 
	QuestionRepository qrepository;
	
	// aloitussivu, jos ei endpointtia
    @RequestMapping(value="/*")
    public String startPage() {	
        return "questionnarylist";
    }
	
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
	public String getQuestionForm(Model model,@PathVariable("id")Long questionnaryId) {
		Question question= new Question();
		model.addAttribute("questionnaryid", questionnaryId);
		model.addAttribute("question", question);
		//model.addAttribute("questionnary",qryrepository.findById(questionnaryId).get());
		model.addAttribute("questions", qryrepository.findById(questionnaryId).get().getQuestions());
		
		
		return "newquestion";
	}
			
		//Uuden kysymyksen tallennus EI TOIMI PRKL!!!
	@PostMapping("/savequestion")
			public String saveQuestions(@ModelAttribute Question question,@ModelAttribute Questionnary questionnary) {	
		
		question.setQuestionnary(questionnary);
			qrepository.save(question);
		
			
			return "redirect:addquestion/"+questionnary.getQuestionnaryId();
	
			
			
			}
			
			
			
		}


