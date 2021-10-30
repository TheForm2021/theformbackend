package ohjelmistoprojekti.com.example.theformbackend.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionnaryRepository;

@Controller
public class QuestionnaryController {
	
	@Autowired
//private QuestionRepository qsrepository;
	//@Autowired
	private QuestionnaryRepository qryrepository;
	
	@GetMapping("questionnarylist")
	public String questionnarylist(Model model) {
		model.addAttribute("questionnaries", qryrepository.findAll());
		return "questionnarylist";
	
}
}
