package it.epicode.U4_W4_D2.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Smartphone extends Dispositivo{
    private String colore;
    private int memoria;
}
