import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        System.out.println("Benvenuto nell'esercizio 2, scrivi tre stringhe.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prima stringa");
        String a = scanner.next();
        System.out.println("Prima seconda");
        String b = scanner.next();
        System.out.println("Prima terza");
        String c = scanner.next();
        System.out.println(a + " " + b + " " + c);
        System.out.println(concat(a, b, c));

String[] parole = {"S","t","r","i","n"};
String stringaAggiunta = "g";
String [] newArray = inserisciInArray(parole,stringaAggiunta);
for(int i= 0; i<newArray.length;i++){
    System.out.println(newArray[i]);
}


    }

    public static String concat(String a, String b, String c) {
        String ris = a + " " + b + " " + c;
        return new StringBuilder(ris).reverse().toString();
    }


    public static String[] inserisciInArray(String [] parole, String stringaAggiunta) {
        String[] newArray = new String[6];

        newArray[0] = parole[0];
        newArray[1] = parole[1];
        newArray[2] = stringaAggiunta;
        newArray[3] = parole[2];
        newArray[4] = parole[3];
        newArray[5] = parole[4];

return newArray;
    }
}

