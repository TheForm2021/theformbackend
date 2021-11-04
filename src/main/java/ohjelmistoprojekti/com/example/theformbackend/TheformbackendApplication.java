package ohjelmistoprojekti.com.example.theformbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti.com.example.theformbackend.domain.Question;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.domain.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.domain.QuestionnaryRepository;

@SpringBootApplication
public class TheformbackendApplication {

	private static final Logger log= LoggerFactory.getLogger(TheformbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TheformbackendApplication.class, args);
	}
	
	

	@Bean
	public CommandLineRunner demo(QuestionRepository qrepository, QuestionnaryRepository qryrepository) {
		return(args) -> {
			
			
			log.info("Tallennetaan uusia kyselyitä:");
			Questionnary qry1= new Questionnary("Kysely 1", "Random kysymyksiä");
			Questionnary qry2= new Questionnary("Kysely 2", "Kaikenlaisia kyssäreitä");
			Questionnary qry3= new Questionnary("Kysely 3", "Turhia kysymyksiä");
			
			qryrepository.save(qry1);
			qryrepository.save(qry2);
			qryrepository.save(qry3);
			
			Question q1= new Question("Onko kivaa?", qry1);
			Question q2=new Question("Miten menee?", qry1);
			Question q3= new Question("Toimiiko mikään?", qry1);
			Question q4= new Question("Toimiiko mikään?", qry2);
			
			qrepository.save(q1);
			qrepository.save(q2);
			qrepository.save(q3);
			qrepository.save(q4);
			
		
			
			log.info("Haetaan kaikki kyselyt:");
			for(Questionnary questionnary :qryrepository.findAll()) {
				log.info(questionnary.toString());
			}

			
			};
			
				
				
				
				
			}

}
