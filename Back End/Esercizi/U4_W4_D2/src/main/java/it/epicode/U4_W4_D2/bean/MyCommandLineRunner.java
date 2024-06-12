package it.epicode.U4_W4_D2.bean;

import it.epicode.U4_W4_D2.U4W4D2Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


//COMMAND LINE RUNNER SERVE PER INSIERIRE QUI I COMANDI DA RUNNER E POI SI FA RUNNARE IL MAIN, OTTERREMO LO STESSO RISULTATO
// LASCIANDO IL MAIN PULITO
@Component // INSERIRE SEMPRE COMPONENT
public class MyCommandLineRunner implements CommandLineRunner { //IMPLEMENTARE SEMPRE COMMAND LINE RUNNER
    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(U4W4D2Application.class);

        Aula aula = ctx.getBean(Aula.class);
        System.out.println(aula);


		/*Dispositivo dispositivo = ctx.getBean(Dispositivo.class);
		System.out.println(dispositivo);*/

        Scuola scuola = ctx.getBean(Scuola.class);
        System.out.println(scuola);


    }
}
