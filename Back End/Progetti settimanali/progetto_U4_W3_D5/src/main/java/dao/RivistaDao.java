package dao;

import entity.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RivistaDao {


    private EntityManager em;

    public RivistaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Rivista rivista){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(rivista);
        et.commit();
    }

    public Rivista getById(int id){
        return em.find(Rivista.class,id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Rivista rivista = getById(id);

        if(rivista!=null){
            em.remove(rivista);
        }
        else{
            System.out.println("Rivista non trovata");
        }

        et.commit();

    }
}
