package it.epicode.U5_W1_D4.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricola;


    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String indirizzo;


    @OneToMany(mappedBy = "studente",fetch = FetchType.EAGER) //fetch type eager la lista di dispositivi viene popolata immediatamente
    private List<Dispositivo> dispositivi = new ArrayList<>();



}
