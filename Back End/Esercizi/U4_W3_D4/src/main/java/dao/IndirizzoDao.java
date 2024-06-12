package dao;

import entity.Indirizzo;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


//Utilizzando il 1 to 1 ho dovuto cerare anche una classe IndirizzoDao per utilizzare i suoi metodi
// con hibernate, in modo da poter salvare i dati di indirizzo nel DB
public class IndirizzoDao {

    private EntityManager em;

    public IndirizzoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Indirizzo indirizzo){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(indirizzo);
        et.commit();
    }

    public Indirizzo getById(int matricola){
        Indirizzo s = em.find(Indirizzo.class,matricola);

        return s;
    }

    public void delete(Indirizzo indirizzo){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(indirizzo);
        et.commit();
    }

}
