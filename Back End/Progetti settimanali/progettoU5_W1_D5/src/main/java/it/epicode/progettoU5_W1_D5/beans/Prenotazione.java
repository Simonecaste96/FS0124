package it.epicode.progettoU5_W1_D5.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue
    private int idPrenotazione;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazionePrenotata;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente prenotataDa;


    private LocalDate dataPrenotazione;


    private LocalDate dataFinePrenotazione;

    @OneToMany(mappedBy = "idEvento")
    private List<Biglietto> listaBiglietti;


    /*@Override
    public String toString() {
        return "Prenotazione{" +
                "idPrenotazione=" + idPrenotazione +
                ", postazionePrenotata=" + postazionePrenotata +
                ", prenotataDa=" + prenotataDa +
                ", dataPrenotazione=" + dataPrenotazione +
                ", dataFinePrenotazione=" + dataFinePrenotazione +
                ", listaBiglietti=" + listaBiglietti +
                '}';
    }*/


    //invece di cancellare i toString, mantengo i dati ed evito lo stack over flow
    @Override
    public String toString() {
        return "Prenotazione{" +
                "idPrenotazione=" + idPrenotazione +
                ", postazionePrenotataId=" + (postazionePrenotata != null ? postazionePrenotata.getCodiceUnivoco() : "null") +
                ", prenotataDaId=" + (prenotataDa != null ? prenotataDa.getId() : "null") +
                ", dataPrenotazione=" + dataPrenotazione +
                ", dataFinePrenotazione=" + dataFinePrenotazione +
                ", listaBiglietti=" + (listaBiglietti != null ? listaBiglietti.size() : "null") +
                '}';
    }
}
