package it.epicode.u5w1d4esercizio.bean;

import it.epicode.u5w1d4esercizio.U5w1d4esercizioApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(U5w1d4esercizioApplication.class);

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




        Comanda comanda = ctx.getBean("comandatavolo4",Comanda.class);
        comanda.getAntipastiOrdinati().stream().forEach(e-> System.out.println("Antipasti: "+e.getNome()+" "+e.getPrezzo()+"€"));
        comanda.getPizzeOrdinate().stream().forEach(e-> System.out.println("Pizze: "+e.getNome()+" "+e.getPrezzoBase()+"€"));
        comanda.getDrinkOrdinati().stream().forEach(e-> System.out.println("Bevande: "+e.getNome()+" "+e.getPrezzo()+"€"));
        System.out.println();
        System.out.println("Per un totale di €:");comanda.contoTotalePerTavolo1(4);




    }


}
