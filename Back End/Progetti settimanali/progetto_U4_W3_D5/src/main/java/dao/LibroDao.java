package dao;

import entity.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibroDao {


    private EntityManager em;

    public LibroDao(EntityManager em) {
        this.em = em;
    }

    public void save(Libro libro){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(libro);
        et.commit();
    }

    public Libro getById(int id){
        return em.find(Libro.class,id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Libro libro = getById(id);

        if(libro!=null){
            em.remove(libro);
        }
        else{
            System.out.println("Libro non trovato");
        }

        et.commit();

    }
}
