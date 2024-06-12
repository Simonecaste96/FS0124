package it.epicode.U5_W1_D4.bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
public class Smartphone extends Dispositivo{


    private String colore;
    private int memoria;
}
