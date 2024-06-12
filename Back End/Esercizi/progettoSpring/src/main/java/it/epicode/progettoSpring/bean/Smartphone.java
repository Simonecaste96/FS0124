package it.epicode.progettoSpring.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Smartphone extends Dispositivo{
    private String colore;
    private int memoria;
}
