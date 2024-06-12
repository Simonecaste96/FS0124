package it.epicode.u5w1d4esercizio.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Data
@ToString
public class Pizze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private boolean xl;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="pizza_ingredienti",
    joinColumns = @JoinColumn(name="pizza_id"),
    inverseJoinColumns = @JoinColumn(name="ingrediente_id"))
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

