package Biblioteca;

import java.time.LocalDate;

import java.util.Objects;

public class Rivista extends DatiTesto{

    private Periodicita periodicita ;

    public Rivista(String codiceIsbn, String titolo, String annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rivista rivista = (Rivista) o;
        return Objects.equals(periodicita, rivista.periodicita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), periodicita);
    }
}
