package entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "studenti")
public class Studente {
    @Id
    @GeneratedValue
    private int matricola;
    @Column(nullable = false, length = 30)
    private String nome;
    @Column(nullable = false, length = 30)
    private String cognome;

    @Column(name = "data_nascita",nullable = false)
    private LocalDate dataNascita;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_studente", nullable = false)
    private TipoStudente tipoStudente;
//Variabile per l'esempio EMBEDDED@Embedded //Creo istanza della classe indirizzo e duno annotazione Embedded per collegarlo a studente
//private Indirizzo indirizzo;

    //JOIN COLUMN DEFINISCE ANCHE IL LATO PROPRIETARIO DELLA RELAZIONE(STUDENTE), IN QUANTO NON CI SONO INFO DI STUDENTE NELLA CLASSE INDIRIZZO

    @OneToOne
    @JoinColumn(name="indirizzo_id")
    private Indirizzo indirizzo;

    public Studente(int matricola, String nome, String cognome, LocalDate dataNascita) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public Studente(){

    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public TipoStudente getTipoStudente() {
        return tipoStudente;
    }

    public void setTipoStudente(TipoStudente tipoStudente) {
        this.tipoStudente = tipoStudente;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "matricola=" + matricola +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}