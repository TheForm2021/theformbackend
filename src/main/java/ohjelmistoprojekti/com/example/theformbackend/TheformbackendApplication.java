package ohjelmistoprojekti.com.example.theformbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionRepository;
import ohjelmistoprojekti.com.example.theformbackend.Web.Questionnary;
import ohjelmistoprojekti.com.example.theformbackend.Web.QuestionnaryRepository;

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
			Questionnary q1= new Questionnary("Kysely 1", "Random kysymyksiä");
			Questionnary q2= new Questionnary("Kysely 2", "Kaikenlaisia kyssäreitä");
			Questionnary q3= new Questionnary("Kysely 3", "Turhia kysymyksiä");
			
			qryrepository.save(q1);
			qryrepository.save(q2);
			qryrepository.save(q3);
			
		
			
			log.info("Haetaan kaikki kyselyt:");
			for(Questionnary questionnary :qryrepository.findAll()) {
				log.info(questionnary.toString());
			}

			
			};
			
				
				
				
				
			}

}
