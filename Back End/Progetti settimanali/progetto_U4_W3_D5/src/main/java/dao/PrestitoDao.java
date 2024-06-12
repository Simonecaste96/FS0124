package dao;

import entity.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

public class PrestitoDao {

    private EntityManager em;

    public PrestitoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(prestito);
        et.commit();
    }

    public Prestito getById(int id){
        return em.find(Prestito.class,id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Prestito prestito = getById(id);

        if(prestito!=null){
            em.remove(prestito);
        }
        else{
            System.out.println("Prestito non presente");
        }

        et.commit();

    }


    //DA TERMINARE
    // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
    public List<Prestito> ricercaPrestitiPerNumeroTessera(Integer numeroTessera) {
        return em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :utenteId AND p.restituzioneEffettiva IS NULL", Prestito.class)
                .setParameter("utenteId", numeroTessera)
                .getResultList();
    }


    // Ricerca di tutti i prestiti scaduti e non ancora restituiti
    public List<Prestito> ricercaPrestitiScaduti() {
        LocalDate oggi = LocalDate.now();
        return em.createQuery("SELECT p FROM Prestito p WHERE p.restituzionePrevista < :oggi AND p.restituzioneEffettiva IS NULL", Prestito.class)
                .setParameter("oggi", oggi)
                .getResultList();
    }

}
