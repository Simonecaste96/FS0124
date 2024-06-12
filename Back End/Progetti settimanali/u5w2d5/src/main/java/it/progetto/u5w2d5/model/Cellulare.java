package it.progetto.u5w2d5.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Cellulari")
//@DiscriminatorValue("CELLULARE")
public class Cellulare extends  Dispositivo{
    private String colore;
    private int memoriaGb;
}
