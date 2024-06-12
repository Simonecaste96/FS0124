package it.epicode.progettoSpring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public abstract class Dispositivo {
    private String modello;
    private String marca;

}
