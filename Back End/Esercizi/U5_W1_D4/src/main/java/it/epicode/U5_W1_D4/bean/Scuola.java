package it.epicode.U5_W1_D4.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Data
@Component
public class Scuola {

    private String nome;
    @Autowired // per distinguere l'oggetto da iniettare quando usato Autowired devo usare anceh Qualifier,
    //e tra parentesi il nome dell'oggetto
    @Qualifier("aula1")
    private Aula aula;
}
