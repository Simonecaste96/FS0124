package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="utenti")

public class Utente {
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(name ="data_nascita")
    private LocalDate dataNascita;
    @Column(name="numero_tessera")
    @Id
    @GeneratedValue()
    private int numeroTessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti = new ArrayList<>();

    public Utente(String nome, String cognome, LocalDate dataNascita, int numeroTessera, List<Prestito> prestiti) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
        this.prestiti = prestiti;
    }


    public Utente() {
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

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroTessera=" + numeroTessera +
                ", prestiti=" + prestiti +
                '}';
    }
}
