package it.epicodeEsercizio.Esercizio_U4_W4_D1.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Tavolo {
    private int numeroTavolo;
    private int numeroCopertiMax;
    private boolean occupato;
    private Comanda conto;

}
