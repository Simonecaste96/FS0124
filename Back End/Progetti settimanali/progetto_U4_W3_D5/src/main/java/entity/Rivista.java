package entity;

import enums.Periodicita;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class Rivista extends DatiTesto{
    @Enumerated(EnumType.STRING)
    @Column(name = "periodicità")
    private Periodicita periodicita ;

    public Rivista(Integer codiceIsbn, String titolo, String annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Rivista() {
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                "} " + super.toString();
    }
}
