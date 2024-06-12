package it.epicode.u5w1d4esercizio.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class Antipasti {



    private String nome;
    private int calorie;
    private double prezzo;

}
