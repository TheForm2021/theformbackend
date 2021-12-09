package ohjelmistoprojekti.com.example.theformbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti.com.example.theformbackend.domain.Answer;
import ohjelmistoprojekti.com.example.theformbackend.domain.AnswerRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Answerer;
import ohjelmistoprojekti.com.example.theformbackend.domain.AnswererRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Option;
import ohjelmistoprojekti.com.example.theformbackend.domain.OptionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Question;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionnaryRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Type;
import ohjelmistoprojekti.com.example.theformbackend.domain.TypeRepository;

@SpringBootApplication
public class TheformbackendApplication {

	private static final Logger log= LoggerFactory.getLogger(TheformbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TheformbackendApplication.class, args);
	}
	
	

	@Bean
	public CommandLineRunner demo(QuestionRepository qrepository, QuestionnaryRepository qryrepository, AnswerRepository arepository, OptionRepository orepository, TypeRepository trepository, AnswererRepository ansrepository) {
		return(args) -> {
			
			
			log.info("Tallennetaan uusia kyselyitä:");
			Questionnary qry1= new Questionnary("Kysely 1", "Textboxkysely");
			Questionnary qry2= new Questionnary("Kysely 2", "Checkboxkysely");
			Questionnary qry3= new Questionnary("Kysely 3", "Radiobuttonkysely");

			
			qryrepository.save(qry1);
			qryrepository.save(qry2);
			qryrepository.save(qry3);
			
			Type t1= new Type("Checkbox");
			Type t2= new Type("Radiobutton");
			Type t3= new Type("Text");			
			trepository.save(t1);
			trepository.save(t2);
			trepository.save(t3);
			
			Question q1= new Question("Onko kivaa?", qry1, t3);
			Question q2=new Question("Miten menee?", qry1, t3);
			
			Question q3= new Question("Paljonko pakkasta?", qry2, t1);
			Question q4= new Question("Lemmikkisi nimi",qry2,t1);
			
			Question q5= new Question("Mikä päivä tänään on?",qry3,t2);
			Question q6= new Question("Kuka on idolisi?",qry3,t2);
			
			qrepository.save(q1);
			qrepository.save(q2);
			qrepository.save(q3);
			qrepository.save(q4);
			qrepository.save(q5);
			qrepository.save(q6);

			Answerer ans1=new Answerer();
			Answerer ans2=new Answerer();
			ansrepository.save(ans1);
			ansrepository.save(ans2);
			
			Answer a1=new Answer("On tosi tosikivaa", q1, ans1);
			Answer a2= new Answer("Jeee mikään ei onnistu",q1, ans2);
			arepository.save(a1);
			arepository.save(a2);
			
			Option o1= new Option("Pertti", q4);
			Option o2= new Option("Hilkka", q4);

			Option o3= new Option("Plussan puolella ollaan", q3);
			Option o4=new Option("Helvettikin jäätyy", q3);
			
			Option o5= new Option("Viikonloppu",q5);
			Option o6= new Option("Perjantai", q5);
			
			Option o7= new Option("Beyonce", q6);
			Option o8= new Option("Madonna", q6);
			Option o9= new Option("Otto", q6);
			orepository.save(o1);
			orepository.save(o2);
			orepository.save(o3);
			orepository.save(o4);
			orepository.save(o5);
			orepository.save(o6);
			orepository.save(o7);
			orepository.save(o8);
			orepository.save(o9);
			
			log.info("Haetaan kaikki vastaajat:");
			for(Answer answer :arepository.findAll()) {
				log.info(answer.toString());
			}
		
			
			log.info("Haetaan kaikki kyselyt:");
			for(Questionnary questionnary :qryrepository.findAll()) {
				log.info(questionnary.toString());
			}
			
			log.info("Haetaan kaikki vastaajat:");
			for(Answerer answerer :ansrepository.findAll()) {
				log.info(answerer.toString());
			}
			
			// jos hakee answereita tässä niin käynnistäminen feilaa

			
			};
			
				
				
				
				
			}

}
