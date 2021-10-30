package ohjelmistoprojekti.com.example.theformbackend.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionRepository;
//import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionaryRepository;

@Controller
public class QuestionaryController {
	
	@Autowired
	private QuestionRepository qsrepository;
	//@Autowired
	//private QuestionaryRepository qryrepository;
	
	@GetMapping("questionlist")
	public String questionlist(Model model) {
		model.addAttribute("questions", qsrepository.findAll());
		return "questionlist";
	
}
}
