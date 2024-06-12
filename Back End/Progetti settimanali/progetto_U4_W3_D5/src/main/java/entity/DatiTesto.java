package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dati_testo")
public class DatiTesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer codiceIsbn;
    @Column()
   private  String titolo;
    @Column(nullable = false,name = "anno_pubblicazione")
   private String annoPubblicazione;
    @Column(nullable = false,name = "numero_pagine")
    private int numeroPagine;

    @ManyToMany(mappedBy = "elementoPrestato")
    private List<Prestito> prestiti = new ArrayList<>();


    public DatiTesto(Integer codiceIsbn, String titolo, String annoPubblicazione, int numeroPagine) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }
    public DatiTesto(){}

    public Integer getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(Integer codiceIsbn) {
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

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "DatiTesto{" +
                "codiceIsbn='" + codiceIsbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione='" + annoPubblicazione + '\'' +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
