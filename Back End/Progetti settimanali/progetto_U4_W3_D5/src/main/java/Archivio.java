import dao.*;
import entity.*;
import enums.Periodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Archivio {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
        EntityManager em = emf.createEntityManager();


        UtenteDao utenteDao = new UtenteDao(em);

        PrestitoDao prestitoDao = new PrestitoDao(em);

        RivistaDao rivistaDao = new RivistaDao(em);
        LibroDao libroDao = new LibroDao(em);

        DatiTestoDao datiTestoDao = new DatiTestoDao(em);




        //Creo utente
        Utente utente = new Utente();
        utente.setNome("Simone");
        utente.setCognome("Castelluccio");
        utente.setDataNascita(LocalDate.of(1996,7,16));

        Utente utente1 = new Utente();
        utente1.setNome("Alice");
        utente1.setCognome("Bianchi");
        utente1.setDataNascita(LocalDate.of(1990, 3, 20));


        Utente utente2 = new Utente();
        utente2.setNome("Bob");
        utente2.setCognome("Verdi");
        utente2.setDataNascita(LocalDate.of(1985, 8, 15));



        utenteDao.save(utente);
        utenteDao.save(utente1);
        utenteDao.save(utente2);


        //Creo libri e riviste
        Libro libro = new Libro();
        libro.setTitolo("Il signore degli anelli");
        libro.setAutore("J.R.R. Tolkien");
        libro.setNumeroPagine(300);
        libro.setAnnoPubblicazione("1954");
        libro.setGenere("Fantasy");



        Libro libro1 = new Libro();
        libro1.setTitolo("1984");
        libro1.setAutore("George Orwell");
        libro1.setAnnoPubblicazione("1949");
        libro1.setNumeroPagine(328);
        libro1.setGenere("Romanzo");



        Libro libro2 = new Libro();
        libro2.setTitolo("La somiglianza");
        libro2.setAutore("Ken Liu");
        libro2.setAnnoPubblicazione("2015");
        libro2.setNumeroPagine(256);
        libro2.setGenere("Romanzo");


        Rivista rivista = new Rivista();
        rivista.setTitolo("Vogue");
        rivista.setNumeroPagine(50);
        rivista.setAnnoPubblicazione("2015");
        rivista.setPeriodicita(Periodicita.SETTIMANALE);

        Rivista rivista2 = new Rivista();
        rivista2.setTitolo("Quattro Ruote");
        rivista2.setNumeroPagine(60);
        rivista2.setAnnoPubblicazione("2024");
        rivista2.setPeriodicita(Periodicita.SETTIMANALE);


        Rivista rivista3 = new Rivista();
        rivista3.setTitolo("Caccia e pesca");
        rivista3.setNumeroPagine(70);
        rivista3.setAnnoPubblicazione("2024");
        rivista3.setPeriodicita(Periodicita.SETTIMANALE);



        //Creo richiesta prestito
        Prestito prestito = new Prestito();
        prestito.setIniziPrestito(LocalDate.of(2024,4,25));
        prestito.setUtente(utente);
        prestito.setRestituzionePrevista(prestito.getIniziPrestito().plusDays(30));
        prestito.getElementoPrestato().add(libro);

        Prestito prestito1 = new Prestito();
        prestito1.setIniziPrestito(LocalDate.of(2024, 4, 25));
        prestito1.setUtente(utente1);
        prestito1.setRestituzionePrevista(prestito1.getIniziPrestito().plusDays(30));
        prestito1.getElementoPrestato().add(libro1);


        Prestito prestito2 = new Prestito();
        prestito2.setIniziPrestito(LocalDate.of(2024, 4, 25));
        prestito2.setUtente(utente2);
        prestito2.setRestituzionePrevista(prestito2.getIniziPrestito().plusDays(30));
        prestito2.getElementoPrestato().add(libro2);


        prestitoDao.save(prestito);
        prestitoDao.save(prestito1);
        prestitoDao.save(prestito2);



       List<Prestito> listaPrestiti = new ArrayList();
        listaPrestiti.add(prestito);
        listaPrestiti.add(prestito1);
        utente.setPrestiti(listaPrestiti);




        //Metodi richiesti del progetto

        //Aggiunta elemento
        //datiTestoDao.save();


        //Eliminazione per ISBN
        //datiTestoDao.delete();


        //Ricerca per ISBN
        //System.out.println(datiTestoDao.getById());

        //Ricerca per autore
        //datiTestoDao.ricercaPerAutore("").forEach(System.out::println);


        //Ricerca per anno
        //datiTestoDao.getByAnno("").forEach(e-> System.out.println(e));


        //Ricerca per titolo o parte
        //System.out.println(datiTestoDao.getByTitolo(""));



//Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
        Prestito prestitoRicerato = prestitoDao.ricercaPrestitiPerNumeroTessera(60).getFirst();
        System.out.println("Numero tessera: " + prestitoRicerato.getUtente().getNumeroTessera() + " intestata a: " + prestitoRicerato.getUtente().getNome() + " " + prestitoRicerato.getUtente().getCognome() + ", data nascita: " + prestitoRicerato.getUtente().getDataNascita());
        prestitoRicerato.getRestituzioneEffettiva();
        System.out.println("Prestito/i: "+prestitoRicerato.getElementoPrestato()+" Data inizio: "+prestitoRicerato.getIniziPrestito()+"Restituzione prevista entro il : "+prestitoRicerato.getRestituzionePrevista());



        //DA TERMINARE
        // Ricerca di tutti i prestiti scaduti e non ancora restituiti
        prestitoDao.ricercaPrestitiScaduti();

    }

}
