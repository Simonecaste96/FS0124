package it.epicode.u5w2d2esercizio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue
    private int id;

    private String categoria;

    private String titolo;

    private String cover;

    private String contenuto;

    private Duration tempoDiLettura;

    @ManyToOne()
    @JoinColumn(name = "autore_id")
    @JsonIgnore
    private Autore autore;


   /* public Blog(String categoria, String titolo, String contenuto, Long tempoDiLettura) {

        this.id = contatore;

        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = "https://picsum.photos/200/300";
        this.contenuto = contenuto;
        this.tempoDiLettura = Duration.ofMinutes(tempoDiLettura);

    }*/

}
