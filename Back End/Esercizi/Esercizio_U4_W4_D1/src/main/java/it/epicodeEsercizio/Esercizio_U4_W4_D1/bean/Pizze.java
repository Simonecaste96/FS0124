package it.epicodeEsercizio.Esercizio_U4_W4_D1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@ToString
public class Pizze {

    private String nome;
    private boolean xl;
    private List<Topping> ingredienti;
    private double prezzoBase;


    private double calorieBase;



    private List<Topping> extra;

    public double calcolaCalorieTotali() {
        double calorieTotali = ingredienti.stream().mapToDouble(Topping::getCalorie).sum() + calorieBase;
        if (extra != null) {
            for (Topping topping : extra) {
                calorieTotali += topping.getCalorie();
            }
        }
        return calorieTotali;
    }

    public double calcolaPrezzoTotale() {
        double prezzoTotale = prezzoBase;
        if(extra !=null)
            prezzoTotale  += extra.size()*0.50;
        return prezzoTotale;
    }

}

