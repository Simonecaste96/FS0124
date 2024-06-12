package it.epicode.progettoU5_W1_D5.beans;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Utente {

    @Id
    @GeneratedValue
    private int id;

    private String username;
    private String nomeCompleto;
    private String email;

    @OneToOne(mappedBy = "utenteId")
    public Biglietto titolareBigliettoId;


    @OneToMany(mappedBy = "prenotataDa")
    public List<Prenotazione> listaPrenotazioni;

}
