package Biblioteca;

import java.time.LocalDate;

import java.util.Objects;

public class Libro extends DatiTesto{

    private String autore;
    private String genere;

    public Libro(String codiceIsbn, String titolo, String annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Libro libro = (Libro) o;
        return Objects.equals(autore, libro.autore) && Objects.equals(genere, libro.genere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), autore, genere);
    }
}
