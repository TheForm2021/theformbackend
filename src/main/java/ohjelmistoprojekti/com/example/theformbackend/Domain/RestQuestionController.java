package ohjelmistoprojekti.com.example.theformbackend.Domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.com.example.theformbackend.Web.Question;
import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.Web.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionnaryRepository;

@RestController
public class RestQuestionController {
	@Autowired
	QuestionRepository qrepository;
	@Autowired
	QuestionnaryRepository qryrepository;
	
	@GetMapping(value="/open/{id}")
	public @ResponseBody  List<Question> questionListRest(@PathVariable("id")Long id,Model model){
	
		return (List<Question>)qryrepository.findById(id).get().getQuestions();
	}
	@GetMapping(value="/list")
	public @ResponseBody List<Questionnary> findQuestionnariesRest(){
		return (List<Questionnary>) qryrepository.findAll();
	}
		
	

}
