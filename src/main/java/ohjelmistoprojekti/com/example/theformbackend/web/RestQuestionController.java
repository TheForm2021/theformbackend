package ohjelmistoprojekti.com.example.theformbackend.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ohjelmistoprojekti.com.example.theformbackend.domain.Question;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionnaryRepository;

@CrossOrigin
@RestController
public class RestQuestionController {
	@Autowired
	QuestionRepository qrepository;
	@Autowired
	QuestionnaryRepository qryrepository;
	
	
	//list of questionnaires questions
	@GetMapping(value="/open/{id}")
	public @ResponseBody  List<Question> questionListRest(@PathVariable("id")Long id,Model model){
	
		return (List<Question>)qryrepository.findById(id).get().getQuestions();
	}
	//list of all questionnairies
	@GetMapping(value="/restquestionnarylist")
	public @ResponseBody List<Questionnary> findQuestionnariesRest(){
		return (List<Questionnary>) qryrepository.findAll();
	}
	
	
	

}
