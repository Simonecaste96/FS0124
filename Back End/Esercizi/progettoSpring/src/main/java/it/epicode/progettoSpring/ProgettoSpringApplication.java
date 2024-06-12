package it.epicode.progettoSpring;

import it.epicode.progettoSpring.appConfig.AppConfig;
import it.epicode.progettoSpring.bean.Aula;
import it.epicode.progettoSpring.bean.Computer;
import it.epicode.progettoSpring.bean.Studente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProgettoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSpringApplication.class, args);


		//Creo un istanza della classe consstesto di Spring inserendo la classe AppConfig.class come paramentro
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

//Recupero dal contesto il bean cerato da Spring ch si trova nella classe Studente
		Studente studente = ctx.getBean("Castelluccio",Studente.class);

		System.out.println("Prima della modifica: ");
		System.out.println(studente);


		/*System.out.println("Dopo della modifica: ");
		studente.setCognome("Andreucci"); // Posso modificare anche le variabili della classe da qui
		System.out.println(studente);*/


		//POSSO PASSARE COME PARAMETRO DI RICERCA ANCHE IL NOME DEL BEAN CHE GLI HO DATO NELLA CLASSE App.config,
		// in modo da non mandare in errore se richiamo oggetti dello stessa classe persona.
		Studente studente2 = ctx.getBean("Alicante",Studente.class);
		System.out.println(studente2);

		Aula aula = ctx.getBean(Aula.class);
		System.out.println(aula);
	}

}
