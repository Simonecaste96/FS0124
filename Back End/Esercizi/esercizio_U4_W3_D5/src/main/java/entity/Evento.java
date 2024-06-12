package entity;

import enums.TipoEvento;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="eventi")
@Inheritance(strategy = InheritanceType.JOINED)

//NamedQuery, per richiamarla devo per prima cosa definirla qui!!
@NamedQuery(name = "getEventoByTitolo", query = "select e from Evento e where e.titolo=:titolo")
public class Evento {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30,nullable = true)
    private String titolo;
    @Column(nullable = true,name = "data_evento")
    private LocalDate dataEvento;
    @Column(length = 100,nullable = true)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento",nullable = true)
    private TipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti",nullable = true)
    private int numeroMassimoPartecipanti;


    public Evento(int id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Evento(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
