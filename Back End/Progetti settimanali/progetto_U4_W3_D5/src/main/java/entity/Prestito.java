package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prestiti")
public class Prestito implements Serializable {


    @Column(name = "inizio_prestito")

    private LocalDate iniziPrestito;
    @Column(name = "restituzione_prevista")
    private LocalDate restituzionePrevista;
    @Column(name = "restituzione_effettiva")
    private LocalDate restituzioneEffettiva;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    @Id
    private Utente utente;

    @ManyToMany
    @JoinTable(
            name = "elemento_prestato",
            joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "codice_isbn")
    )
    private List<DatiTesto> elementoPrestato = new ArrayList<>();

    public Prestito(LocalDate iniziPrestito, LocalDate restituzionePrevista, LocalDate restituzioneEffettiva, Utente utente, List<DatiTesto> elementoPrestato) {
        this.iniziPrestito = iniziPrestito;
        this.restituzionePrevista = restituzionePrevista;
        this.restituzioneEffettiva = restituzioneEffettiva;
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
    }

    public Prestito() {

    }

    public LocalDate getIniziPrestito() {
        return iniziPrestito;
    }

    public void setIniziPrestito(LocalDate iniziPrestito) {
        this.iniziPrestito = iniziPrestito;
    }

    public LocalDate getRestituzionePrevista() {
        return restituzionePrevista;
    }

    public void setRestituzionePrevista(LocalDate restituzionePrevista) {
        this.restituzionePrevista = restituzionePrevista;
    }

    public LocalDate getRestituzioneEffettiva() {
        return restituzioneEffettiva;
    }

    public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
        this.restituzioneEffettiva = restituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<DatiTesto> getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(List<DatiTesto> elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "iniziPrestito=" + iniziPrestito +
                ", restituzionePrevista=" + restituzionePrevista +
                ", restituzioneEffettiva=" + restituzioneEffettiva +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                '}';
    }

}
