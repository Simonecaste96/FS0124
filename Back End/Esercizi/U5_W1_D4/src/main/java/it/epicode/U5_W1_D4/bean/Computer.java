package it.epicode.U5_W1_D4.bean;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString(callSuper = true)
public class Computer extends Dispositivo{


    private int memoriaSsd;
    private String processore;
    private int ram;

}
