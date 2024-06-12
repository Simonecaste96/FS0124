package it.epicodeEsercizio.Esercizio_U4_W4_D1.bean;

import it.epicodeEsercizio.Esercizio_U4_W4_D1.EsercizioU4W4D1Application;
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
        ApplicationContext ctx = new AnnotationConfigApplicationContext(EsercizioU4W4D1Application.class);


        Menu menu = ctx.getBean(Menu.class);
        System.out.println();
        menu.getAntipasti().forEach(e-> System.out.println(e.getNome()+" - Prezzo: "+e.getPrezzo()+" - Calorie: "+e.getCalorie()));

        System.out.println();
        menu.getBevande().forEach(e-> System.out.println(e.getNome()+" "+"Calorie: "+e.getCalorie()+" "+"Prezzo: "+e.getPrezzo()));

        System.out.println();
        menu.getPizze().forEach(e -> {
            System.out.println(e.getNome());
            System.out.println("Ingredienti: ");
            e.getIngredienti().forEach(i -> System.out.println(i.getNome()+" -Calorie: "+i.getCalorie()));
            System.out.println("Calorie base pizza: " + e.getCalorieBase());
            double calorieTotali = e.getCalorieBase() + e.getIngredienti().stream().mapToInt(Topping::getCalorie).sum();
            System.out.println("Calorie totali: " + calorieTotali);
            System.out.println("Prezzo: " + e.getPrezzoBase());
            System.out.println();
        });




        System.out.println();
        System.out.println(" * 50 cent in più per ogni topping extra* ");
        menu.getTopping().forEach(e-> System.out.println(e.getNome()+" "+"Calorie: "+e.getCalorie()));

        System.out.println("**CONTO TAVOLO 2**");

        Comanda comanda = ctx.getBean(Comanda.class);

        Tavolo tavolo = ctx.getBean(Tavolo.class);

       comanda.contoTotalePerTavolo1(2);

       // da terminare comanda.contoTotalePerTavolo2();





		/*Dispositivo dispositivo = ctx.getBean(Dispositivo.class);
		System.out.println(dispositivo);*/




    }
}
