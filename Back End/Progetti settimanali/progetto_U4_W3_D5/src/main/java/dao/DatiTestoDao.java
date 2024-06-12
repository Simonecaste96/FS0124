package dao;

import entity.DatiTesto;
import entity.Libro;
import entity.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DatiTestoDao {


    private EntityManager em;

    public DatiTestoDao(EntityManager em) {
        this.em = em;
    }

    public void save(DatiTesto datiTesto){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(datiTesto);
        et.commit();
    }


    public List<DatiTesto> getByAnno(String annoPubblicazione) {
        String jpql = "SELECT dt FROM DatiTesto dt WHERE dt.annoPubblicazione =: anno";
        return em.createQuery(jpql, DatiTesto.class)
                .setParameter("anno", annoPubblicazione)
                .getResultList();
    }


    public List<DatiTesto> getByTitolo(String titolo) {
        String jpql = "SELECT dt FROM DatiTesto dt WHERE dt.titolo LIKE :titolo";
        return em.createQuery(jpql, DatiTesto.class)
                .setParameter("titolo", "%" + titolo + "%")
                .getResultList();
    }

    public List<DatiTesto> ricercaPerAutore(String autore) {
        String jpql = "SELECT dt FROM DatiTesto dt WHERE dt.autore LIKE :autore";
        return em.createQuery(jpql, DatiTesto.class)
                .setParameter("autore", "%" + autore + "%")
                .getResultList();
    }


    public DatiTesto getById(int id) {
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            return libro;
        } else {
            Rivista rivista = em.find(Rivista.class, id);
            if (rivista != null) {
                return rivista;
            }
        }
        return null;
    }




    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        DatiTesto datiTesto = getById(id);

        if(datiTesto!=null){
            em.remove(datiTesto);
        }
        else{
            System.out.println("Partecipazione non presente");
        }

        et.commit();

    }
}
