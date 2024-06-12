package it.epicode.U4_W4_D2.bean;

import lombok.Data;
import lombok.ToString;


@Data
@ToString(callSuper = true)
public class Computer extends Dispositivo{

    private int memoriaSsd;
    private String processore;
    private int ram;

}
