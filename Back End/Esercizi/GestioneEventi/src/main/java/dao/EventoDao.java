package dao;

import entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDao {


    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }
    //metodo per salvare dati

    public void save(Evento evento){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(evento);
        et.commit();
    }

//metodo per recuperare evento per id
    public Evento getById(int id){
        return em.find(Evento.class,id);
    }



    public void delete(Evento evento){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(evento);
        et.commit();
    }

    //metodo per eliminare eventi direttamente con l'id

    public void deleteById(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Evento e = em.find(Evento.class,id);
        em.remove(e);
        et.commit();

    }
}
