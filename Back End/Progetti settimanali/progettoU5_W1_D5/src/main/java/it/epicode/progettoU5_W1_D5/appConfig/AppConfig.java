package it.epicode.progettoU5_W1_D5.appConfig;

import it.epicode.progettoU5_W1_D5.beans.*;
import it.epicode.progettoU5_W1_D5.enums.Tipo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;


@Configuration
@PropertySource("application.properties")
public class AppConfig {

    //LISTA EDIFICI-------------------------------------
    @Bean(name = "edificio1")
 public Edificio getEdificio1(){
     Edificio edificio1 = new Edificio();
     edificio1.setNome("E1");
     edificio1.setIndirizzo("Via Roma 33");
     edificio1.setCitta("Roma");
     return edificio1;
 }/*
    @Bean(name = "edificio2")
    public Edificio getEdificio2(){
        Edificio edificio2 = new Edificio();
        edificio2.setNome("E2");
        edificio2.setIndirizzo("Via Roma 33");
        edificio2.setCitta("Roma");
        return edificio2;
    }
    @Bean(name = "edificio3")
    public Edificio getEdificio3(){
        Edificio edificio3 = new Edificio();
        edificio3.setNome("E3");
        edificio3.setIndirizzo("Via Roma 33");
        edificio3.setCitta("Roma");
        return edificio3;
    }
*/


    //LISTA POSTAZIONI----------------------------------

    @Bean(name = "postazione1")
    public Postazione getPostazione1(){
        Postazione postazione1 = new Postazione();
        postazione1.setEdificio(getEdificio1());
        postazione1.setTipoPostazione(Tipo.PRIVATO);
        postazione1.setDescrizione("Sala privata");
        postazione1.setNumeroMaxPartecipanti(150);
        return postazione1;
    }
    /*
    @Bean(name = "postazione2")
    public Postazione getPostazione2(){
        Postazione postazione2 = new Postazione();
        postazione2.setEdificio(getEdificio2());
        postazione2.setTipoPostazione(Tipo.SALA_RIUNIONI);
        postazione2.setDescrizione("Sala riunioni");
        postazione2.setNumeroMaxPartecipanti(30);
        return postazione2;
    }
    @Bean(name = "postazione3")
    public Postazione getPostazione3(){
        Postazione postazione3 = new Postazione();
        postazione3.setEdificio(getEdificio3());
        postazione3.setTipoPostazione(Tipo.OPENSPACE);
        postazione3.setDescrizione("Sala riunioni open space");
        postazione3.setNumeroMaxPartecipanti(250);
        return postazione3;
    }*/

    //LISTA UTENTI---------------------------------------
    @Bean(name = "utente1")
    public Utente getUtente1(){
        Utente utente1 = new Utente();
        utente1.setUsername("Rokko");
        utente1.setNomeCompleto("Rocco Barocco");
        utente1.setEmail("roccobarocco@gmail.com");
        return utente1;
    }

    @Bean(name = "utente2")
    public Utente getUtente2(){
        Utente utente2 = new Utente();
        utente2.setUsername("Mimmo");
        utente2.setNomeCompleto("Domenico De Carlo");
        utente2.setEmail("mimmodecarlo@gmail.com");
        return utente2;
    }

    @Bean(name = "utente3")
    public Utente getUtente3(){
        Utente utente3 = new Utente();
        utente3.setUsername("Mariuccio");
        utente3.setNomeCompleto("Mario Mariottide");
        utente3.setEmail("supermario@gmail.com");
        return utente3;
    }

//LISTA PRENOTAZIONI------------------------------------------
    @Bean(name = "prenotazione1")
    public Prenotazione getPrenotazione1(){
        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setPrenotataDa(getUtente1());
        prenotazione1.setPostazionePrenotata(getPostazione1());
        prenotazione1.setDataPrenotazione(LocalDate.of(2024,5,20));
        prenotazione1.setDataFinePrenotazione(prenotazione1.getDataPrenotazione().plusDays(1));
        return prenotazione1;
    }

    @Bean(name = "biglietto1")
    public Biglietto getBiglietto1(){
     Biglietto biglietto1 = new Biglietto();
     biglietto1.setUtenteId(getUtente1());
     biglietto1.setIdEvento(getPrenotazione1());

       return biglietto1;
    }

    @Bean(name = "biglietto2")
    public Biglietto getBiglietto2(){
        Biglietto biglietto2 = new Biglietto();
        biglietto2.setUtenteId(getUtente2());
        biglietto2.setIdEvento(getPrenotazione1());

        return biglietto2;
    }

    @Bean(name = "biglietto3")
    public Biglietto getBiglietto3(){
        Biglietto biglietto3 = new Biglietto();
        biglietto3.setUtenteId(getUtente3());
        biglietto3.setIdEvento(getPrenotazione1());

        return biglietto3;
    }
/*
    @Bean(name = "prenotazione2")
    public Prenotazione getPrenotazione2(){
        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setPrenotataDa(getUtente2());
        prenotazione2.setPostazionePrenotata(getPostazione2());
        prenotazione2.setDataPrenotazione(LocalDate.of(2024,5,25));
        prenotazione2.setDataFinePrenotazione(prenotazione2.getDataPrenotazione().plusDays(1));
        return prenotazione2;
    }

    @Bean(name = "prenotazione3")
    public Prenotazione getPrenotazione3(){
        Prenotazione prenotazione3 = new Prenotazione();
        prenotazione3.setPrenotataDa(getUtente3());
        prenotazione3.setPostazionePrenotata(getPostazione3());
        prenotazione3.setDataPrenotazione(LocalDate.of(2024,5,25));
        prenotazione3.setDataFinePrenotazione(prenotazione3.getDataPrenotazione().plusDays(1));
        return prenotazione3;
    }
    */



}
