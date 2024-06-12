package it.epicodeEsercizio.Esercizio_U4_W4_D1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
public class Topping {
    private String nome;
    private int calorie;
}
