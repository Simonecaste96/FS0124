package Biblioteca;


import java.time.LocalDate;
import java.util.Objects;

public class DatiTesto {
   private String codiceIsbn;
   private  String titolo;
   private String annoPubblicazione;

    private int numeroPagine;


    public DatiTesto(String codiceIsbn, String titolo, String annoPubblicazione, int numeroPagine) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(String codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(String annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "DatiTesto{" +
                "codiceIsbn='" + codiceIsbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatiTesto datiTesto = (DatiTesto) o;
        return numeroPagine == datiTesto.numeroPagine && Objects.equals(codiceIsbn, datiTesto.codiceIsbn) && Objects.equals(titolo, datiTesto.titolo) && Objects.equals(annoPubblicazione, datiTesto.annoPubblicazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
    }
}
