package epicode.dao;
import epicode.entity.Studente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudenteDao {

    private EntityManager em;

    public StudenteDao(EntityManager em) {
        this.em = em;
    }

    public void save(Studente studente){
    //Tecnica della transazione = Operazione atomica con tecnica del tutto o niente
        EntityTransaction et = em.getTransaction();  //getTransaction, creo la transazione
        et.begin(); //begin inizializzo la transazione
        em.persist(studente);//metodo persist serve per inserire, tra parentesi il
        et.commit(); // commit = invio le modifiche
    }

    //Estrapolazione dati in base alla matricola
    public Studente getById(int matricola){
    Studente s = em.find(Studente.class,matricola);//(Dato che estrae dal database = Studente.class, chiave primaria = matricola)
        return  s;
    }


    public void delete(Studente studente){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(studente);
        et.commit();
    }

    public void deleteById(int matricola){
        EntityTransaction et = em.getTransaction();
        et.begin();
        Studente s = em.find(Studente.class,matricola);
        em.remove(s);
        et.commit();
    }

}
