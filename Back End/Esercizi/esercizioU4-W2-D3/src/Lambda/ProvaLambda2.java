package Lambda;

import java.util.Comparator;
import java.util.TreeSet;

public class ProvaLambda2 {
    public static void main(String[] args) {



        //Qui non ho usato la classe Comparatore creata, l'ho passata direttamente come parametro (new Comparator<String>()), in modo da cerare una FUNZIONA ANONIMA, difatti il metodo
        // si scrive subito sotto, in automatico.
        TreeSet<String> parole = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        parole.add("Java");
        parole.add("HTML");
        parole.add("JavaScript");
        parole.add("Angular");

        System.out.println(parole);

//Funzioanmento identico a ProvaLambda!!

    }
}
