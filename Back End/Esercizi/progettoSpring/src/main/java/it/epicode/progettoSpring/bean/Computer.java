package it.epicode.progettoSpring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString(callSuper = true)
public class Computer extends Dispositivo{

    private int memoriaSsd;
    private String processore;
    private int ram;

}
