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
			Questionnary qry4 = new Questionnary("Etäopiskelukysely", "Kyselyllä selvitetään miten Haaga-Helian Pasilan kampuksen opiskelijat kokeneet korona-ajan etäopiskelun ja vastausten avulla pyritään kehittämään etäopiskelua tulevaisuudessa opiskelijoiden toivomaan suuntaan.");
			qryrepository.save(qry1);
			qryrepository.save(qry2);
			qryrepository.save(qry3);
			qryrepository.save(qry4);
			
			log.info("Tallennetaan kysymysten tyypit:");
			Type t1= new Type("Checkbox");
			Type t2= new Type("Radiobutton");
			Type t3= new Type("Text");			
			trepository.save(t1);
			trepository.save(t2);
			trepository.save(t3);
			
			log.info("Tallennetaan kysymykset:");
			Question q1= new Question("Onko kivaa?", qry1, t3);
			Question q2=new Question("Miten menee?", qry1, t3);
			
			Question q3= new Question("Paljonko pakkasta?", qry2, t1);
			Question q4= new Question("Lemmikkisi nimi",qry2,t1);
			
			Question q5= new Question("Mikä päivä tänään on?",qry3,t2);
			Question q6= new Question("Kuka on idolisi?",qry3,t2);
			
			Question q7= new Question("Milloin olet aloittanut opiskelun Haaga-Heliassa?",qry4,t2);
			Question q8= new Question("Missä koulutusohjelmassa opiskelet?",qry4,t2);
			Question q9= new Question("Onko opintosi toteutettu koronan aikana:",qry4,t2);
			Question q10= new Question("Onko opiskelumotivaatiosi koronan aikaisen etäopiskelun vuoksi",qry4,t2);
			Question q11= new Question("Jos etäopiskelu on vaikuttanut opiskelumotivaatioosi, kerro millä tavoin",qry4,t3);
			Question q12= new Question("Olisitko mieluummin lähiopetuksessa vai etäopetuksessa?",qry4,t2);
			Question q13= new Question("Kurssien työmäärä on tuntunut samanlaiselta etä- ja lähiopetuksessa",qry4,t2);
			Question q14= new Question("Pitäisikö kaikista kursseista olla tarjolla myös korona-ajan jälkeen sekä lähi- että etätoteutus",qry4,t2);
			Question q15= new Question("Mitkä työkalut olet kokenut tärkeimmiksi etäopetuksessa",qry4,t1);
			Question q16= new Question("Miten etäopiskelua voisi mielestäsi voisi kehittää?",qry4,t3);
			
			qrepository.save(q1);
			qrepository.save(q2);
			qrepository.save(q3);
			qrepository.save(q4);
			qrepository.save(q5);
			qrepository.save(q6);
			qrepository.save(q7);
			qrepository.save(q8);
			qrepository.save(q9);
			qrepository.save(q10);
			qrepository.save(q11);
			qrepository.save(q12);
			qrepository.save(q13);
			qrepository.save(q14);
			qrepository.save(q15);
			qrepository.save(q16);
			
			
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
			
			Option o10= new Option("2017", q7);
			Option o11= new Option("2018", q7);
			Option o12= new Option("2019", q7);
			Option o13= new Option("2020", q7);
			Option o14= new Option("2021", q7);
			
			Option o15= new Option("ASSI", q8);
			Option o16= new Option("FINA", q8);
			Option o17= new Option("HELI", q8);
			Option o18= new Option("LIIDI", q8);
			Option o19= new Option("LIIPO", q8);
			Option o20= new Option("JOURA", q8);
			Option o21= new Option("HETI", q8);
			
			Option o22= new Option("kokonaan etänä", q9);
			Option o23= new Option("kokonaan lähiopetuksena", q9);
			Option o24= new Option("hybridimallilla", q9);
			
			Option o25= new Option("noussut", q10);
			Option o26= new Option("laskenut", q10);
			Option o27= new Option("pysynyt ennallaan", q10);
			Option o28= new Option("en osaa sanoa", q10);
			
			Option o29= new Option("lähiopetuksessa", q12);
			Option o30= new Option("etäopetuksessa", q12);
			Option o31= new Option("molemmissa", q12);
			
			Option o32= new Option("täysin samaa mieltä", q13);
			Option o33= new Option("osittain samaa mieltä", q13);
			Option o34= new Option("en osaa sanoa", q13);
			Option o35= new Option("osittain eri mieltä", q13);
			Option o36= new Option("täysin eri mieltä", q13);
			
			Option o37= new Option("kyllä", q14);
			Option o38= new Option("ei", q14);
			
			Option o39= new Option("Teams", q15);
			Option o40= new Option("Zoom", q15);
			Option o41= new Option("Moodle", q15);
			Option o42= new Option("Adobe Connect", q15);
			Option o43= new Option("Whatsapp", q15);
			Option o44= new Option("Sähköposti", q15);
			Option o45= new Option("OneDrive", q15);
			Option o46= new Option("MyNet", q15);
			
			orepository.save(o1);
			orepository.save(o2);
			orepository.save(o3);
			orepository.save(o4);
			orepository.save(o5);
			orepository.save(o6);
			orepository.save(o7);
			orepository.save(o8);
			orepository.save(o9);
			orepository.save(o10);
			orepository.save(o11);
			orepository.save(o12);
			orepository.save(o13);
			orepository.save(o14);
			orepository.save(o15);
			orepository.save(o16);
			orepository.save(o17);
			orepository.save(o18);
			orepository.save(o19);
			orepository.save(o20);
			orepository.save(o21);
			orepository.save(o22);
			orepository.save(o23);
			orepository.save(o24);
			orepository.save(o25);
			orepository.save(o26);
			orepository.save(o27);
			orepository.save(o28);
			orepository.save(o29);
			orepository.save(o30);
			orepository.save(o31);
			orepository.save(o32);
			orepository.save(o33);
			orepository.save(o34);
			orepository.save(o35);
			orepository.save(o36);
			orepository.save(o37);
			orepository.save(o38);
			orepository.save(o39);
			orepository.save(o40);
			orepository.save(o41);
			orepository.save(o42);
			orepository.save(o43);
			orepository.save(o44);
			orepository.save(o45);
			orepository.save(o46);
			
			
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
			
			
			};
			
				
				
				
				
			}

}
