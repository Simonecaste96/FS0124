import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class ClasseProva {
    static Logger logger = LoggerFactory.getLogger("loggerProva1");


    public static void main(String[] args) {
        /*logger.warn("Sto lanciando l'applicazione");
        System.out.println("contenuto dell'appProva");
        logger.warn("Applicazione terminata");*/

        int[] numeri = new int[5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = random.nextInt(1, 11);
            System.out.println("Numero casuale " + i + ": " + numeri[i]);
        }

        // Ciclo do-while per permettere all'utente di inserire numeri in posizioni specifiche
        int posizione;
        do {
            System.out.print("Inserisci la posizione (0 per terminare): ");
            posizione = scanner.nextInt();

            if (posizione == 0) {
                break; // Termina il ciclo se l'utente inserisce 0
            }

            if (posizione < 1 || posizione > numeri.length) {
                System.out.println("Posizione non valida. Riprova.");
                continue; // Salta al prossimo ciclo se la posizione non è valida
            }

            System.out.print("Inserisci il numero: ");
            int numeroInserito = scanner.nextInt();

            // Assegna il numero inserito nella posizione specificata dell'array
            numeri[posizione - 1] = numeroInserito;

            // Stampa dell'array aggiornato
            System.out.println("Array aggiornato:");
            stampaNumeriAggiornati(numeri);
        } while (true);

        scanner.close();
        System.out.println("Programma terminato.");
    }


    // Metodo per stampare un array
    public static void stampaNumeriAggiornati(int[] array) {
        for (int numero : array) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
