package it.epicode.progettoSpring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
public class Studente {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String indirizzo;
    private List<Dispositivo> dispositivi;

}
