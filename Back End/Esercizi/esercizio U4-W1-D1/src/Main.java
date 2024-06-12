import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto nella mia calcolatrice elementare");
        System.out.println("Inserire 1 per Addizione,inserire 2 per Sottrazione,inserire 3 per Moltiplicazione,inserire 4 per Divisione, 5 per la radice quadrata");
        int select = scanner.nextInt();


        switch (select) {
            case 1:
                System.out.println("Inserire primo numero");
                double a1 = scanner.nextDouble();

                System.out.println("Inserire secondo numero");
                double b1 = scanner.nextDouble();
                double add = addizione(a1, b1);
                System.out.println("Il risultato dell' addizione è: " + add);
                break;
            case 2:
                System.out.println("Inserire primo numero");
                double a2 = scanner.nextDouble();

                System.out.println("Inserire secondo numero");
                double b2 = scanner.nextDouble();
                double sot = sottrazione(a2, b2);
                System.out.println("Il risultato della sottrazione è: " + sot);
                break;
            case 3:
                System.out.println("Inserire primo numero");
                double a3 = scanner.nextDouble();

                System.out.println("Inserire secondo numero");
                double b3 = scanner.nextDouble();
                double molt = moltiplicazione(a3, b3);
                System.out.println("Il risultato della moltiplicazione è: " + molt);
                break;
            case 4:
                System.out.println("Inserire primo numero");
                double a4 = scanner.nextDouble();

                System.out.println("Inserire secondo numero");
                double b4 = scanner.nextDouble();
                double div = divisione(a4, b4);
                System.out.println("Il risultato della divisione è: " + div);
                break;
            case 5:
                System.out.println("Inserire il numero");
                double a5 = scanner.nextDouble();

                double sqr = sqrT(a5);
                System.out.println("La radice quadrata di " + a5 + " è: " + sqr);
                break;
            default:
                System.out.println("Selezione non valida");
        }


    }


    //metodi per calcolatrice
    public static double addizione(double a, double b) {
        double ris = a + b;
        return ris;
    }

    public static double sottrazione(double a, double b) {
        double ris = a - b;
        return ris;
    }

    public static double moltiplicazione(double a, double b) {
        double ris = a * b;
        return ris;
    }

    public static double divisione(double a, double b) {
        double ris = a / b;
        return ris;
    }

    public static double sqrT(double a) {
        double ris = Math.sqrt(a);
        return ris;
    }

}