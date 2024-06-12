package it.epicode.U4_W4_D2.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Component("aula1") // Aula è stata segnata con l'annotazione component, ora gli oggetti di questa classe
// verranno cerato automaticamente da spring

//@PropertySource: ANNOTAZIONE CHE COLLEGA il file application.properties che sono variabili di ambiente
@PropertySource("application.properties")
public class Aula {

    @Value("${aula.nome}")
    private String nome;

    //inietto la lista di studenti prendendoli direttamente dal contesto
    @Autowired
    private List<Studente> studenti;

    /*@Autowired//Constructor injection, setto studenti e li inietto in aula
    public Aula(List<Studente> studenti){
        this.studenti = studenti;
    }*/


   /* @Autowired // crea prima oggetto AULA e poi setta nell'aula una lista di studenti nel contesto
    public void setStudenti(List<Studente> studenti){
        this.studenti = studenti;
    }*/


}
