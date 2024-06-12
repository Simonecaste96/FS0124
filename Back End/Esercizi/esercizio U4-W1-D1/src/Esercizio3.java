import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        System.out.println("Benvenuto nell'esercizio 3");
        System.out.println("Calcolo perimetro rettangolo");
        Scanner scanner = new Scanner (System.in);
        System.out.println("Misura lato corto");
        double c = scanner.nextDouble();
        System.out.println("Misura lato lungo");
        double l = scanner.nextDouble();
        System.out.println(perimetroRettangolo(c,l));



        /*----ES.2------*/
        System.out.println("Calcola pari e dispari, inserisci un numero");
        int n = scanner.nextInt();
        System.out.println(pariDispari(n));

        /*----ES.3------*/
        System.out.println("Calcola l'area del triangolo!");
        System.out.println("Misura l1");
        double l1 = scanner.nextDouble();
        System.out.println("Misura l2");
        double l2 = scanner.nextDouble();
        System.out.println("Misura l3");
        double l3 = scanner.nextDouble();
        System.out.println("L'area del triangolo è:" + areaTriangolo(l1,l2,l3));


    }
    public static double perimetroRettangolo(double c, double l){
    double perim = c*2+l*2;
    return perim;
    }

    public static String pariDispari(int n){
        int ris = n%2;
        if(ris==0){return "Il numero è paro!";
        } else {
            return "Il numero è dispari!";
        }

    }

    public static double areaTriangolo(double l1, double l2, double l3){
        double s = (l1 + l2 + l3) / 2;
        double erone = Math.sqrt(s * (s - l1) * (s - l2) * (s - l3));
        return erone;

    }

}
