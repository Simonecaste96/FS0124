import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Esercizio2 {

    static Logger logger = LoggerFactory.getLogger("loggerProva1");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.warn("Sto lanciando l'applicazione");

        try {
            System.out.println("Inserisci i km percorsi:");
            int km = scanner.nextInt();

            System.out.println("Inserisci i litri consumati:");
            int l = scanner.nextInt();

            if (l == 0) {
                throw new ArithmeticException("Litri per 0 non ammessi");
            }

            System.out.println("Il consumo è di: " + consumo(km, l) + " km/l");

        } catch (ArithmeticException e) {
            System.out.println("Litri per 0 non ammessi");
        } catch (Exception e) {
            System.out.println("Si è verificato un errore durante l'input.");
        } finally {
            scanner.close();
            logger.warn("Sto terminando l'applicazione");
        }
    }

    // Metodo per calcolare i chilometri per litro (km/l)
    public static double consumo(int km, int l) {
        return (double) km / l;
    }
}
