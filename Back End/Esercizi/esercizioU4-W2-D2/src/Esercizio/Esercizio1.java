package Esercizio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Esercizio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        HashSet<String> parole = new HashSet<>();
        ArrayList<String> duplicati = new ArrayList<>();

        System.out.println("Quante parole?");
        //svuotaaaaaaaa!!!!!
        int n = scanner.nextInt();

        int i = 0;
        scanner.nextLine();
        while (i < n) {
            System.out.println("Parola?");
            System.out.println();
            String parola = scanner.nextLine();

            if (!parole.add(parola)) {
                duplicati.add(parola);

            }
            i++;
        }

        System.out.println("I duplicati sono: ");
        System.out.println(duplicati);
        System.out.println();
        System.out.println("Il numero delle parole uniche è: " + parole.size());
        System.out.println();
        System.out.println("Lista delle parole: ");
        System.out.println(parole);
    }

}
