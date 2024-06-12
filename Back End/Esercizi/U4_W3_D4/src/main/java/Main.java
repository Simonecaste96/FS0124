import dao.IndirizzoDao;
import dao.StudenteDao;
import entity.Indirizzo;
import entity.Studente;
import entity.TipoStudente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode_jpa");
        EntityManager em = emf.createEntityManager();

        StudenteDao studenteDao = new StudenteDao(em);

        //Chiamo anche un instanza di IndirizzoDao per utilizzare i metodi di salvataggio ecc.
        IndirizzoDao indirizzoDao = new IndirizzoDao(em);


        Studente s1 = new Studente();
        s1.setNome("Matteo");
        s1.setCognome("Castelluccio");
        s1.setDataNascita(LocalDate.of(1993, 9, 10));
        s1.setTipoStudente(TipoStudente.FULL_TIME);

//Ora creo un istanza della variabile indirizzo e richiamo i suoi metodi SET
        Indirizzo indirizzo = new Indirizzo();

        indirizzo.setVia("Via Oder 11");
        indirizzo.setComune("Fiumicino");
        indirizzo.setProvincia("RM");

        //METODO EMBEDDED
        //Setto l'indirizzo sullo studente s1, passando al metodo setIndirizzo della classe Studente,
        // l'istanza di indrizzo creata, che al suo interno contiene le sue varibili via, comune, provincia
        //s1.setIndirizzo(indirizzo);

        //SALVO S1
       // dao.save(s1);


        //METODO 1 TO 1
        //PRIMA DI SALVARE S1 DEVO SALVARE PER FORZA INDIRIZZO, PERCHE ESSENDO UNA CLASSE APPARTE SE NON LO SALVO LUI NON ESISTERA', SE NON ESISTE
        // NON POSSO PASSARLO A S1 E SALVARLO
        indirizzoDao.save(indirizzo);

        //LO ASSOCIO AD S1
        s1.setIndirizzo(indirizzo);

        //SALVO S1 DOPO CHE HO SETTTATO IL SUO INDIRIZZO
        studenteDao.save(s1);







    }
}
