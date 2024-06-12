package it.epicode.progettoU5_W1_D5.beans;

import it.epicode.progettoU5_W1_D5.enums.Tipo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Postazione {
    @Id
    @GeneratedValue()
    private int codiceUnivoco;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private Tipo tipoPostazione;


    private int numeroMaxPartecipanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "postazionePrenotata")
    private List<Prenotazione> prenotazioni;

    /*@Override
    public String toString() {
        return "Postazione{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                ", edificio=" + edificio +
                ", prenotazioni=" + prenotazioni +
                '}';
    }*/


    //invece di cancellare i toString, mantengo i dati ed evito lo stack over flow
    @Override
    public String toString() {
        return "Postazione{" +
                "codiceUnivoco=" + codiceUnivoco +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                ", edificio=" + edificio.getId() +
                ", prenotazioniCount=" + (prenotazioni != null ? prenotazioni.size() : "null") +
                '}';
    }
}
