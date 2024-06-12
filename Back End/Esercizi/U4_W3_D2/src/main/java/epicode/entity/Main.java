package epicode.entity;

import epicode.dao.StudenteDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        StudenteDao dao = new StudenteDao(em);

       /* Studente s1 = new Studente();
        s1.setNome("Simone");
        s1.setCognome("Castelluccio");
        s1.setIndirizzo("Via Oder 11");
        s1.setDataNascita(LocalDate.of(1996,7,16));

        dao.save(s1);*/

        //CON IL JPA SENZA FARE UNA QUERY SQL ABBIAMO ESTRAPOLATO I DATI DAL DATABES TRAMITE MATRICOLA
        /*Studente s2 = dao.getById(2);
        System.out.println(s2);*/




        //richiamo il metodo delete e gli passo s2
       //dao.delete(s2);

       //richiamo il metodo deleteById e gli passo la matricola dello studente da eliminare
        //dao.deleteById(1);

        //update di un record in tabella
        Studente s3 = dao.getById(3);
       s3.setIndirizzo("Via Baldo degli Ubaldi");
       dao.save(s3);

    }
}
