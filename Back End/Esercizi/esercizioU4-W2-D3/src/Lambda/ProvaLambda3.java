package Lambda;

import java.util.TreeSet;

public class ProvaLambda3 {

    public static void main(String[] args) {

        //QUESTA E L'ESPRESSIONE LAMBDA, ANCORA PIU SEMPLICE UTILIZZANDO (o1,o2)->o2.compareTo(o1)

        TreeSet<String> parole = new TreeSet<>((s1, s2) -> s2.compareTo(s1));

        parole.add("Java");
        parole.add("HTML");
        parole.add("JavaScript");
        parole.add("Angular");

        //Stampo parole
        System.out.println(parole);

        System.out.println();

        //ForEach con espressione lambda e-> System.out.println(e)
        parole.forEach(e -> System.out.println(e));

        System.out.println();

//Supporta anche gli operatori logici
        parole.removeIf(e -> e.contains("H"));

        //Destrutturo nuovamente
        parole.forEach(e -> System.out.println(e));


        //Cancello dalla lista parole con quantiotà dicaratteri pari
        parole.removeIf(e -> {
            if (e.length() % 2 == 0)
                return true;
            else
                return false;
        });

        System.out.println();

        parole.forEach(e-> System.out.println(e));

    }



}
