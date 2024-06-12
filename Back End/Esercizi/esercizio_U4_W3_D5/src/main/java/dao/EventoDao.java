package dao;

import entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class EventoDao {


    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }
    //metodo per salvare dati

    public void save(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
    }

    //metodo per recuperare evento per id
    public Evento getById(int id) {
        return em.find(Evento.class, id);
    }


    public void delete(Evento evento) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }

    //metodo per eliminare eventi direttamente con l'id

    public void deleteById(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        Evento e = em.find(Evento.class, id);
        em.remove(e);
        et.commit();

    }

    //Sia nelal NamedQuery che nella query semplice, bisogna inserire nei parametri i nomi utilizzati nelle CLASSI non i nomi delle colonne del DB
    public List getEventoByTitolo(String titolo) {
        Query query = em.createNamedQuery("getEventoByTitolo");
        query.setParameter("titolo",titolo);
        return query.getResultList();
    }


    //A differenza della NamedQuery, la query semplice non viene definita nella classe Evento, ma viene definita direttamente qui e poi utilizzata nel main.
    public List getEventoByDay(LocalDate dataEvento){
       Query query =  em.createQuery("select e from Evento e where e.dataEvento= : dataEvento");
        query.setParameter("dataEvento",dataEvento);
        return query.getResultList();
    }

}
