package Stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProvaStream {

    public static void main(String[] args) {
        List<String> lista = List.of("FS0124", "JavaScript", "Python", "JavaScript");


        //LO STREAM MANTIENE UN FLUSSO, A MENO CHE NON SI CHIUDA CON UN METODO FINALòIZZATORE TIPO FOR EACH

        //METODI NON FINALIZZATORI

        //metodo filter "filtra", non è finalizzante
        lista.stream().filter(e -> e.length() <= 6).forEach(e -> System.out.println(e));

        System.out.println();
        System.out.println();


        //metodo limit
        lista.stream().limit(3).forEach(e -> System.out.println(e));


        System.out.println();
        System.out.println();


        //Metodo MAP manipola --> modifica, di fatti nella stampa non c'è il contenuto, ma è stata stampata la lunghezza di ogni parola.
        lista.stream().map(e -> e.length()).forEach(e -> System.out.println(e));


        System.out.println();
        System.out.println();


        //metodo DISTINCT elimina i duplicati
        lista.stream().distinct().forEach(e -> System.out.println(e));

        System.out.println();
        System.out.println();


        lista.stream().sorted((e1, e2) -> e1.compareTo(e2)).forEach(e -> System.out.println(e));



        //metodi finalizzanti



        //metodo reduce
        int risultato = lista.stream().map(e -> e.length()).reduce(0, (somma, l) -> somma + l);

        System.out.println("Somma di tuti i cratatteri di ogni parola contenuta: " + risultato);

        System.out.println();
        System.out.println();


        //metodo FILTER
        int risultato2 = lista.stream().map(e-> e.length()).filter(l->l<=9).reduce(0,(somma,l)->somma+l);
        System.out.println("Somma di tuti i caratteri di ogni parola contenuta con una lunghezza minore o uguale a 9 è: "+risultato2);


       String risultato3 =  lista.stream().sorted().distinct().collect(Collectors.joining(" - "));

        System.out.println();
        System.out.println();

        System.out.println("La lista delle parole è stata concatenata con collect e poi e stato aggiunto il - con Collectors.joining: "+risultato3);





    }
}
