import dao.EventoDao;
import entity.Evento;
import entity.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestione_eventi");
        EntityManager em = emf.createEntityManager();
        EventoDao dao = new EventoDao(em);

        Evento evento1 = new Evento(0, "Compleanno", LocalDate.of(2024, 7, 16), "Festa 18 anni di Simone", TipoEvento.PRIVATO, 30);
        Evento evento2 = new Evento(0, "Matrimonio", LocalDate.of(2024, 7, 16), "Matrimonio di Maria e Paolo, a cena ci saranno 2 persone celiache", TipoEvento.PRIVATO, 60);
        Evento evento3 = new Evento(0, "Compleanno", LocalDate.of(2024, 7, 16), "Festa 30 anni di Andrea, affittata anche piscina", TipoEvento.PRIVATO, 25);
        Evento evento4 = new Evento(0, "Festa 1 Maggio", LocalDate.of(2024, 5, 1), "Concerto 1 Maggio", TipoEvento.PUBBLICO, 25);


        //Update evento
        Evento eventoPUT = dao.getById(16);
        eventoPUT.setDescrizione("Evento annullato");
        dao.save(eventoPUT);

        //Elimina oggetto
        //dao.deleteById(10);



    }
}
