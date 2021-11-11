package ohjelmistoprojekti.com.example.theformbackend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
//@Autowired 
//	private QuestionRepository qrepository;
	
	// ilman endpointtia ohjautuu aina kyselylistaukseen
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
	
		
}


