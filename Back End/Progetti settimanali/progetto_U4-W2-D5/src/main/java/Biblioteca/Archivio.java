package Biblioteca;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;


public class Archivio {


    public static void main(String[] args) {


        List<String> datiCaricati = caricaDatiSalvati();
        List <DatiTesto> archivio = new ArrayList<>();



        Scanner scanner = new Scanner(System.in);
        int scelta;
        do {
            mostraMenu();

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    aggiungiElemento(scanner,archivio);
                    break;
                case 2:
                    rimuoviIsbn(scanner, archivio);
                    break;
                case 3:
                    ricercaIsbn(scanner, archivio);
                    // ricerca per ISBN
                    break;
                case 4:
                    ricercaAnnoPubblicazione(scanner,archivio);
                    //ricerca per anno di pubblicazione
                    break;
                case 5:
                    ricercaAutore(scanner, archivio);
                    // ricerca per autore
                    break;
                case 6:
                    visualizzaArchivio( );
                    //archivio completo
                    break;
                case 0:
                    salva(archivio);
                    break;
                default:
                    System.out.println("Selezione non valida. Riprova.");
            }
        } while (scelta != 0);

        scanner.close();
    }


    private static void mostraMenu() {
        System.out.println("Seleziona un'operazione:");
        System.out.println("1. Aggiunta di un elemento");
        System.out.println("2. Rimozione di un elemento dato un codice ISBN");
        System.out.println("3. Ricerca per ISBN");
        System.out.println("4. Ricerca per anno di pubblicazione");
        System.out.println("5. Ricerca per autore");
        System.out.println("6. Vedi archivio completo");
        System.out.println("0. Salva ed esci");

    }


    private static void aggiungiElemento(Scanner scanner, List<DatiTesto> archivio) {

        System.out.println("Seleziona il tipo di elemento da aggiungere:");
        System.out.println("1. Libro");
        System.out.println("2. Rivista");

        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consumiamo il newline

        if (scelta == 1) {
            System.out.println("Titolo:");
            String titolo = scanner.nextLine();

            System.out.println("Codice ISBN:");
            String codiceIsbn = scanner.nextLine();

            System.out.println("Anno di pubblicazione (YYYY):");
            String annoPubblicazione = scanner.nextLine();

            System.out.println("Numero di pagine:");
            int numeroPagine = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Autore:");
            String autore = scanner.nextLine();


            System.out.println("Genere:");
            String genere = scanner.nextLine();

            Libro libro = new Libro(codiceIsbn,titolo,annoPubblicazione,numeroPagine,autore,genere);

            archivio.add(libro);
            salva(archivio);
        } else if (scelta == 2) {
            System.out.println("Titolo:");
            String titolo = scanner.nextLine();

            System.out.println("Codice ISBN:");
            String codiceIsbn = scanner.nextLine();

            System.out.println("Anno di pubblicazione (YYYY):");
            String annoPubblicazione = scanner.nextLine();

            System.out.println("Numero di pagine:");
            int numeroPagine = scanner.nextInt();

            System.out.println("Periodicità (1-MENSILE, 2-SETTIMANALE, 3-SEMESTRALE):");
            int sceltaP = scanner.nextInt();
            Periodicita periodicita = null;
            switch (sceltaP){
                case 1:
                    periodicita = Periodicita.MENSILE;
                   break;
                case 2:
                    periodicita = Periodicita.SETTIMANALE;
                    break;
                case 3:
                    periodicita = Periodicita.SEMESTRALE;
                    break;
                default:
            }

            Rivista rivista = new Rivista(codiceIsbn,titolo,annoPubblicazione,numeroPagine,periodicita);
            archivio.add(rivista);
            salva(archivio);
        } else {
            System.out.println("Selezione non valida. Ritorna al menu principale.");
        }
    }

    private static void rimuoviIsbn(Scanner scanner, List<DatiTesto> archivio) {
        caricaDatiSalvati();
        System.out.println("Inserisci il codice ISBN dell'elemento da rimuovere: ");
        String isbn = scanner.nextLine();

        System.out.println("Prima della rimozione:");
        archivio.forEach(System.out::println);


        boolean condizione = archivio.stream().anyMatch(e -> e.getCodiceIsbn().equals(isbn));
        System.out.println(condizione);
        if (condizione) {
            System.out.println("Elemento trovato con il codice ISBN: " + isbn);

            archivio.removeIf(e -> e.getCodiceIsbn().equals(isbn));
            System.out.println("Elemento rimosso con successo.");
        } else {
            System.out.println("Nessun elemento trovato con il codice ISBN: " + isbn);

        }

        System.out.println("Dopo la rimozione:");
        archivio.forEach(System.out::println);
    }


    private static void ricercaIsbn(Scanner scanner, List<DatiTesto> archivio) {
        caricaDatiSalvati();
        System.out.println("Inserisci il codice ISBN dell'elemento da ricercare: ");
        String isbn = scanner.nextLine();
        boolean condizione = archivio.stream().anyMatch(e->e.getCodiceIsbn().equals(isbn));
        if(condizione){
            System.out.println("Elemento trovato");
            archivio.stream()
                    .filter(e -> e.getCodiceIsbn().equals(isbn))
                    .forEach(e -> System.out.println(
                            "Titolo: " + e.getTitolo() +
                                    ", Anno pubblicazione: " + e.getAnnoPubblicazione() +
                                    ", Codice ISBN: " + e.getCodiceIsbn() +
                                    ", Numero pagine: " + e.getNumeroPagine()));
        } else {
            System.out.println("Nessun elemento trovato con il codice ISBN specificato.");
        }


    }

    private static void ricercaAnnoPubblicazione(Scanner scanner, List<DatiTesto> archivio) {
        caricaDatiSalvati();
        System.out.println("Inserisci l'anno dell'elemento da ricercare (YYYY): ");
        String inputAnno = scanner.nextLine();

        try {
            boolean condizione = archivio.stream().anyMatch(e -> e.getAnnoPubblicazione().equals(inputAnno));

            if (condizione) {
                archivio.stream()
                        .filter(e -> e.getAnnoPubblicazione().equals(inputAnno))
                        .forEach(e -> System.out.println(
                                "Titolo: " + e.getTitolo() +
                                        ", Anno pubblicazione: " + e.getAnnoPubblicazione() +
                                        ", Codice ISBN: " + e.getCodiceIsbn() +
                                        ", Numero pagine: " + e.getNumeroPagine()));
            } else {
                System.out.println("Nessun elemento trovato per l'anno specificato.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato dell'anno non valido. Assicurati di inserire l'anno nel formato corretto (YYYY).");
        }
    }

    private static void ricercaAutore(Scanner scanner, List<DatiTesto> archivio) {
        List<String> datiCaricati = caricaDatiSalvati();
        System.out.println("Inserisci l'autore da ricercare: ");
        String autore = scanner.nextLine();

        boolean condizione = datiCaricati.stream()
                .filter(str -> str.contains("Tipo: Libro"))
                .anyMatch(str -> str.contains("Autore: " + autore));

        if (condizione) {
            archivio.stream()
                    .filter(e -> e instanceof Libro && ((Libro) e).getAutore().equals(autore))
                    .forEach(e -> System.out.println(
                            "Titolo: " + e.getTitolo() +
                                    ", Autore: " + ((Libro) e).getAutore() +
                                    ", Anno pubblicazione: " + e.getAnnoPubblicazione() +
                                    ", Codice ISBN: " + e.getCodiceIsbn() +
                                    ", Numero pagine: " + e.getNumeroPagine()));
        } else {
            System.out.println("Nessun libro trovato per l'autore specificato.");
        }
    }

    public static void salva(List<DatiTesto> archivio) {
        List<DatiTesto> libri = archivio.stream()
                .filter(e -> e instanceof Libro)
                .collect(Collectors.toList());

        List<DatiTesto> riviste = archivio.stream()
                .filter(e -> e instanceof Rivista)
                .collect(Collectors.toList());

        String strLibri = libri.stream()
                .map(e -> {
                    Libro libro = (Libro) e;
                    return "Tipo: Libro @ Codice ISBN: " + libro.getCodiceIsbn() +  " @ Autore : " + libro.getAutore() + " @ Titolo: " + libro.getTitolo() + " | Anno: "
                            + libro.getAnnoPubblicazione() + " @ Pagine: " + libro.getNumeroPagine();
                })
                .collect(Collectors.joining("#"));

        String strRiviste = riviste.stream()
                .map(e -> {
                    Rivista rivista = (Rivista) e;
                    return "Tipo: Rivista @ Titolo: " + rivista.getTitolo() + " @ Anno: "
                            + rivista.getAnnoPubblicazione() + " @ Numero: " + rivista.getNumeroPagine() + " @ Periodicità : " + rivista.getPeriodicita();
                })
                .collect(Collectors.joining("#"));

        File fileSalvataggio = new File("PersistenceFile/newFile.txt");

        try {
            FileUtils.writeStringToFile(fileSalvataggio, strLibri + "#" + strRiviste, Charset.defaultCharset(), false);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio nel file: " + e.getMessage());
        }
    }


    public static List<String> caricaDatiSalvati() {
        List<String> datiSalvati = new ArrayList<>();
        File fileSalvataggio = new File("PersistenceFile/newFile.txt");

        try {
            String str = FileUtils.readFileToString(fileSalvataggio, Charset.defaultCharset());
            String[] prodottiStr = str.split("#");
            datiSalvati.addAll(Arrays.asList(prodottiStr));
        } catch (IOException e) {
            System.out.println("Errore durante la lettura dal file: " + e.getMessage());
        }

        return datiSalvati;
    }
    public static void visualizzaArchivio() {
        File fileSalvataggio = new File("PersistenceFile/newFile.txt");

        try {
            String str = FileUtils.readFileToString(fileSalvataggio, Charset.defaultCharset());
            String[] prodottiStr = str.split("#");

            Arrays.stream(prodottiStr).forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Errore durante la lettura dal file: " + e.getMessage());
        }
    }


}

