package it.epicode.U4_W4_D2.bean;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.List;
@Data
public class Studente {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String indirizzo;
    private List<Dispositivo> dispositivi;

}
