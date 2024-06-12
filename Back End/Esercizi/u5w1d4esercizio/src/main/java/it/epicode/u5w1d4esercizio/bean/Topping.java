package it.epicode.u5w1d4esercizio.bean;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Data
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int calorie;


    @ManyToMany(mappedBy = "ingredienti", fetch = FetchType.EAGER)
    private List<Pizze> pizze;



    // ricorda di aggiugnere to string e risolvere lista delle pizze per many to many //AGGIUNTO

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", calorie=" + calorie +
                ", pizze=" + pizze +
                '}';
    }
}
