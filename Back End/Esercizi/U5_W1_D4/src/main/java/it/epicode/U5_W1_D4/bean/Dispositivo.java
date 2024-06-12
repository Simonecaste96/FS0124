package it.epicode.U5_W1_D4.bean;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dispositivo {

    @Id
    @GeneratedValue
    private int id;

    private String modello;
    private String marca;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private Studente studente;

    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", modello='" + modello + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
