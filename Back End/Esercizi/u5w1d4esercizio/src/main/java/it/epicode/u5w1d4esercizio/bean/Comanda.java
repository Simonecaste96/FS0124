package it.epicode.u5w1d4esercizio.bean;



import it.epicode.u5w1d4esercizio.enums.StatoOrdine;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Comanda {
    private Tavolo tavolo;


    private List<Pizze> pizzeOrdinate;
    private List<Antipasti> antipastiOrdinati;
    private List<Drink> drinkOrdinati;


    private int numeroComanda;

    private StatoOrdine statoOrdine;

    private int pax;


    private LocalDateTime oraAcquisizione = LocalDateTime.now();


    private int costoCoperto;



public void contoTotalePerTavolo1(int numeroTavolo){
        int tavolo = getTavolo().getNumeroTavolo();
        if(tavolo==numeroTavolo){

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


}
