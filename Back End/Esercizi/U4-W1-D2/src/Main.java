import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*----ES.1---*/
        System.out.println("Inserire una frase per sapere se la lunghezza è pari o dispari");
        String frase = scanner.next();
        System.out.println(stringaPariDispari(frase));

        /*----ES.2---*/
        System.out.println("Inserire un anno (es:2012) per sapere se è bisestile oppure no");
        int anno = scanner.nextInt();
        annoBisestile(anno);


        /*----ES.3---*/
        System.out.println("Inserire un numero intero per stamparlo in lettere");
        int numero= scanner.nextInt();
        System.out.println(numeroInStringa(numero));

        /*----ES.4---*/
        System.out.println("Inserisci una stringa oppure -> :q <- per uscire)");
        String frase2= scanner.next();
        qMethod(frase2);
        System.out.println();

        /*----ES.5---*/
        System.out.println("Inserire un numero intero per inizializzare il timer");
        int contatore= scanner.nextInt();
        countDown(contatore);





    }
    /*----METODO ES.1---*/
    public static String stringaPariDispari(String p){
        if (p.length()%2==0){
            return "Pari";
        }
        else{
            return "Dispari";
        }
    }
    /*----METODO ES.2---*/

    public static void annoBisestile(int p){
if (p % 4 == 0 && p % 100 !=0 || p % 400 == 0) {
    System.out.println(p + " è un anno bisestile.");

        }
else{
    System.out.println(p + " non è un anno bisestile.");

}
    }
    /*----METODO ES.3---*/
    public static String numeroInStringa(int p){
        switch(p){
            case 0:
            return "Zero";
            case 1:
                return "Uno";
            case 2:
                return "Due";
            case 3:
                return "Tre";
            default:
                return "ERROR";
        }
    }


    /*----METODO ES.4---*/
public static void qMethod(String p){
    int i = 0;
    while (i < p.length()) {
        System.out.print(p.charAt(i));
        if (i != p.length() - 1) {
            System.out.print(",");
        }
        i++;
    }

}



    /*----METODO ES.5---*/

   public static void
   countDown(int p){
for (; p >= 0; p--){
   System.out.println(p);
}


   }


}