package it.epicodeEsercizio.Esercizio_U4_W4_D1.bean;


import it.epicodeEsercizio.Esercizio_U4_W4_D1.enums.StatoOrdine;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



import java.time.LocalDateTime;
import java.util.List;

@Data
@Component
@RequiredArgsConstructor
@PropertySource("application.properties")
public class Comanda {
    private Tavolo tavolo;


    private List<Pizze> pizzeOrdinate;
    private List<Antipasti> antipastiOrdinati;
    private List<Drink> drinkOrdinati;


    private int numeroComanda;

    private StatoOrdine statoOrdine;

    private int pax;


    private LocalDateTime oraAcquisizione = LocalDateTime.now();


    @Value("${costo.coperto}")
    private int costoCoperto;

    public Comanda(Tavolo tavolo, List<Pizze> pizzeOrdinate, List<Antipasti> antipastiOrdinati, List<Drink> drinkOrdinati, int numeroComanda, StatoOrdine statoOrdine, int pax) {
        this.tavolo = tavolo;
        this.pizzeOrdinate = pizzeOrdinate;
        this.antipastiOrdinati = antipastiOrdinati;
        this.drinkOrdinati = drinkOrdinati;
        this.numeroComanda = numeroComanda;
        this.statoOrdine = statoOrdine;
        this.pax = pax;
    }

public void contoTotalePerTavolo1(int numeroTavolo){
        boolean tavolo = getTavolo().equals(numeroTavolo);
        if(tavolo){

            double prezzoDrink =getDrinkOrdinati().stream().mapToDouble(Drink::getPrezzo).sum();
            double prezzoAntipasti = getAntipastiOrdinati().stream().mapToDouble(Antipasti::getPrezzo).sum();
            double prezzoPizze = getPizzeOrdinate().stream().mapToDouble(Pizze::getPrezzoBase).sum();
            double conto = prezzoDrink+prezzoAntipasti+prezzoPizze+costoCoperto;
            System.out.println(conto);
        }

    else{
            System.out.println("Tavolo non trovato");
        }

}


    public void contoTotalePerTavolo2(Tavolo tavolo){

        double prezzoDrink = tavolo.getConto().getDrinkOrdinati().stream().mapToDouble(Drink::getPrezzo).sum();
        double prezzoAntipasti = tavolo.getConto().getAntipastiOrdinati().stream().mapToDouble(Antipasti::getPrezzo).sum();
        double prezzoPizze = tavolo.getConto().getPizzeOrdinate().stream().mapToDouble(Pizze::getPrezzoBase).sum();
        double conto = prezzoDrink+prezzoAntipasti+prezzoPizze+costoCoperto;
        System.out.println(conto);

        System.out.println("Tavolo non trovato");

    }




}
