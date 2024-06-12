package it.epicode.progettoU5_W1_D5;

import it.epicode.progettoU5_W1_D5.beans.*;
import it.epicode.progettoU5_W1_D5.enums.Tipo;
import it.epicode.progettoU5_W1_D5.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {

    //inietto i vari service da cui richiamare i metodi
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;


    @Autowired
    private BigliettoService bigliettoService;


    @Override
    public void run(String... args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProgettoU5W1D5Application.class);

        /*
        //recupero bean utenti da appConfig e li salvo nel db
        Utente utente1 = ctx.getBean("utente1", Utente.class);
        utenteService.inserisciUtente(utente1);

        Utente utente2 = ctx.getBean("utente2", Utente.class);
        utenteService.inserisciUtente(utente2);

        Utente utente3 = ctx.getBean("utente3", Utente.class);
        utenteService.inserisciUtente(utente3);





*/


     /*    //recupero edificio
        Edificio edificio1 = ctx.getBean("edificio1", Edificio.class);
        edificioService.inserisciEdificio(edificio1);

       Edificio edificio2 = ctx.getBean("edificio2", Edificio.class);
        edificioService.inserisciEdificio(edificio2);

        Edificio edificio3 = ctx.getBean("edificio3", Edificio.class);
        edificioService.inserisciEdificio(edificio3);*/


//recupero postazione
        /*Postazione postazione1 = ctx.getBean("postazione1", Postazione.class);
        postazione1.setEdificio(edificio1);
        postazioneService.inserisciPostazione(postazione1);*/

       /* Postazione postazione2 = ctx.getBean("postazione2", Postazione.class);
        postazione1.setEdificio(edificio2);
        postazioneService.inserisciPostazione(postazione2);

        Postazione postazione3 = ctx.getBean("postazione3", Postazione.class);
        postazione1.setEdificio(edificio3);
        postazioneService.inserisciPostazione(postazione3);*/





        //recupero le prenotazioni bean da appConfig
        /*Prenotazione prenotazione1 = ctx.getBean("prenotazione1", Prenotazione.class);
        prenotazioneService.inserisciPrenotazione(prenotazione1);*/

       /* Prenotazione prenotazione2 = ctx.getBean("prenotazione2", Prenotazione.class);
        prenotazioneService.inserisciPrenotazione(prenotazione2);

        Prenotazione prenotazione3 = ctx.getBean("prenotazione3", Prenotazione.class);
        prenotazioneService.inserisciPrenotazione(prenotazione3);*/



        //inserisco biglietti creati con i bean
       /* Biglietto biglietto1 = ctx.getBean("biglietto1", Biglietto.class);
        bigliettoService.inserisciBiglietto(biglietto1);

        Biglietto biglietto2 = ctx.getBean("biglietto2", Biglietto.class);
        bigliettoService.inserisciBiglietto(biglietto2);

        Biglietto biglietto3 = ctx.getBean("biglietto3", Biglietto.class);
        bigliettoService.inserisciBiglietto(biglietto3);*/


       postazioneService.getfindByTipoAndCitta(Tipo.PRIVATO,"Roma").forEach(e-> System.out.println("Risultato ricerca: "+" Tipo postazione: "+e.getTipoPostazione()+" Descrizione: "+e.getDescrizione()+" Numero massimo di persone: "+e.getNumeroMaxPartecipanti()+" Città: "+e.getEdificio().getCitta()+" Indirizzo: "+e.getEdificio().getIndirizzo()));

    }
}
