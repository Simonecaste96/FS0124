package it.epicode.u5w2d2teoria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Studente {
@Id
@GeneratedValue
    private int matricola;
    //variabile statica per manterere un valore comune tra tutti gli studenti creati.
    // Io l'ho impostata ad 1, di default parte da 0
   // private static int contatore; ora non mi interessa piu la variabile statica, il db genera per me

    private String nome;

    private String cognome;

    private LocalDate dataNascita;

    private String linkFoto; // inserisco una nuva proprietà linkFoto per aggiungere una foto


    private String email;

    @ManyToOne
    @JoinColumn(name="aula_id")
    @JsonIgnore
    private Aula aula;





   /* public Studente(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        //Assegno un contatore statico in modo da generare una matricola diversa che incrementi in modo automatico
       /contatore++;
        this.matricola = contatore;  // ora matricola avra il valore di cont ad ogni istanza creata, incrementato di 1
    }*/
}
