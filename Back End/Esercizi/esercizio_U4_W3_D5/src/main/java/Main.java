import dao.EventoDao;
import entity.Concerto;
import entity.Evento;
import entity.PartitaDiCalcio;
import enums.TipoEvento;
import enums.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");
        EntityManager em = emf.createEntityManager();
        EventoDao eventoDao = new EventoDao(em);

        Evento evento1 = new Evento(0, "Compleanno", LocalDate.of(2024, 7, 16), "Festa 18 anni di Simone", TipoEvento.PRIVATO, 30);
        Evento evento2 = new Evento(0, "Matrimonio", LocalDate.of(2024, 7, 16), "Matrimonio di Maria e Paolo, a cena ci saranno 2 persone celiache", TipoEvento.PRIVATO, 60);
        Evento evento3 = new Evento(0, "Compleanno", LocalDate.of(2024, 7, 16), "Festa 30 anni di Andrea, affittata anche piscina", TipoEvento.PRIVATO, 25);
        Evento evento4 = new Evento(0, "Festa 1 Maggio", LocalDate.of(2024, 5, 1), "Concerto 1 Maggio", TipoEvento.PUBBLICO, 25);


        //Update evento
        /*Evento eventoPUT = eventoDao.getById(16);
        eventoPUT.setDescrizione("Evento annullato");
        eventoDao.save(eventoPUT);*/

        //Elimina oggetto
        //dao.deleteById(10);




        //Utilizzo la Namedquery personalizzata creata in EventoDao, cercando l'evento per titolo
        eventoDao.getEventoByTitolo("Festa 1 Maggio").forEach(System.out::println);


        //Utilizzo query semplice diretta
        eventoDao.getEventoByDay(LocalDate.of(2024,7,16)).forEach(System.out::println);



       PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio();
        partitaDiCalcio.setSquadraCasa("Inter");
        partitaDiCalcio.setSquadraOspite("Salernitana");
        partitaDiCalcio.setSquadraVincente("Salernitana");

        partitaDiCalcio.setGolSquadraCasa(1);
        partitaDiCalcio.setGolSquadraOspite(2);

        partitaDiCalcio.setDescrizione("Partita Seria A - 1°");
        partitaDiCalcio.setTitolo("Inter-Salernitana");
        partitaDiCalcio.setNumeroMassimoPartecipanti(80000);
        partitaDiCalcio.setDataEvento(LocalDate.of(2026,5,6));


        eventoDao.save(partitaDiCalcio);




        Concerto concerto = new Concerto();
        concerto.setTipoEvento(TipoEvento.PUBBLICO);
        concerto.setGenere(Genere.CLASSICA);
        concerto.setInStreaming(false);
        concerto.setTitolo("Concerto Vladimir Horowitz");
        concerto.setDescrizione("Concerto solo piano di Vladimi Horowitz");
        concerto.setNumeroMassimoPartecipanti(500);



    }
}
