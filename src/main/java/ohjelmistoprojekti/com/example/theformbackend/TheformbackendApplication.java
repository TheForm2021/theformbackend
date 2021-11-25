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
			Questionnary qry1= new Questionnary("Kysely 1", "Random kysymyksiä");
			Questionnary qry2= new Questionnary("Kysely 2", "Kaikenlaisia kyssäreitä");
			Questionnary qry3= new Questionnary("Kysely 3", "Turhia kysymyksiä");
			
			qryrepository.save(qry1);
			qryrepository.save(qry2);
			qryrepository.save(qry3);
			
			Type t1= new Type("Checkbox");
			Type t2= new Type("Radiobutton");
			
			trepository.save(t1);
			trepository.save(t2);
			
			Question q1= new Question("Onko kivaa?", qry1, t1);
			Question q2=new Question("Miten menee?", qry1, t1);
			Question q3= new Question("Toimiiko mikään?", qry1, t2);
			Question q4= new Question("Toimiiko mikään?", qry2, t2);
			
			qrepository.save(q1);
			qrepository.save(q2);
			qrepository.save(q3);
			qrepository.save(q4);
			
			Answerer ans1=new Answerer();
			Answerer ans2=new Answerer();
			ansrepository.save(ans1);
			ansrepository.save(ans2);
			
			Answer a1=new Answer("On tosi tosikivaa", q1, ans1);
			Answer a2= new Answer("Jeee mikään ei onnistu",q1, ans2);
			arepository.save(a1);
			arepository.save(a2);
			
			Option o1= new Option("Ikinä ei ole kivaa", q1);
			Option o2= new Option("Pelkkää hauskuutta", q1);
			
			orepository.save(o1);
			orepository.save(o2);
		
			
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
