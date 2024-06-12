package it.epicode.progettoU5_W1_D5.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Edificio {

    @Id
    @GeneratedValue()
    private int id;

    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazione;

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
