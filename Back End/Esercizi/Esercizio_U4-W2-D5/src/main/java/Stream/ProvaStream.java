package Stream;


import java.util.*;
import java.util.stream.Collectors;

public class ProvaStream {

    public static void main(String[] args) {
        Prodotto libro1 = new Prodotto(100l, "Il signore degli anelli", "Libri", 101);
        Prodotto libro2 = new Prodotto(101L, "Il giorno nero", "Libri", 102);
        Prodotto libro3 = new Prodotto(102L, "Collision", "Libri", 10);
        Prodotto libro4 = new Prodotto(103L, "Marracash", "Libri", 13);
        Prodotto baby1 = new Prodotto(104L, "pannolini", "Baby", 7);
        Prodotto baby2 = new Prodotto(105L, "tutina", "Baby", 15);
        Prodotto baby3 = new Prodotto(106L, "cappello", "Baby", 10);
        Prodotto boys1 = new Prodotto(107L, "scarpe", "Boys", 70);
        Prodotto boys2 = new Prodotto(108L, "felpa", "Boys", 40);
        Prodotto boys3 = new Prodotto(109L, "pantalone", "Boys", 40);
        List<Prodotto> prodotti = List.of(libro1, libro2, libro3, libro4, boys1, boys2, boys3, baby1, baby2, baby3);


        System.out.println();
        System.out.println();

        //creo una lista con i prezzi dei prodotti
        List<Double> l1 = prodotti.stream().map(prodotto -> prodotto.getPrezzo()).collect(Collectors.toList());
        l1.forEach(n -> System.out.println(n));


        System.out.println();
        System.out.println();

        //Utilizzo collect creando un SET perciò eliminio i duplicati dei prezzi
        Set<Double> s1 = prodotti.stream().map(e -> e.getPrezzo()).collect(Collectors.toSet());
        s1.forEach(e -> System.out.println(e));

        System.out.println();
        System.out.println();

        //Metodo Collectors.toMap vuole 2 parametri!!
        Map<Long, Double> m1 = prodotti.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getPrezzo()));

        //Fa caso al toMap: non ho usato lambda, In Java, l'operatore :: viene chiamato "method reference" (riferimento a metodo).
        // È stato introdotto nelle versioni più recenti di Java e offre un modo conciso per fare riferimento a un metodo esistente senza doverlo eseguire immediatamente.
        /*Map<Long,Double> m1 = prodotti.stream().collect(Collectors.toMap(Prodotto::getId, Prodotto::getPrezzo));*/


        //Ovviamente anche il forEach vuole 2 paramertri per stampare!
        m1.forEach((aLong, aDouble) -> System.out.println(aLong + " " + aDouble));


        System.out.println();
        System.out.println();

        //Collectors groupingBay riesce a ragruppare in una mappa dei dati creando anche dei dati di sintesi.
        Map<String, List<Prodotto>> m2 = prodotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria));
        m2.forEach((e1, e2) -> System.out.println(e1 + " " + e2));


        System.out.println();
        System.out.println();


        //Metodo counting conta quanti elementi ci saranno in base alla prima chiave di raggruppamento, ma sta volta senza crare una lista ma per conteggio usanto counting.
        Map<String, Long> m3 = prodotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria, Collectors.counting()));

        m3.forEach((e1, e2) -> System.out.println(e1 + " " + e2));


        System.out.println();
        System.out.println();

        //Un altro metodo di collectors è avaragingDouble che permette di fare la media, perciò passo due parametri alla groupoingBy
        Map<String, Double> m4 = prodotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria, Collectors.averagingDouble(Prodotto::getPrezzo)));
        m4.forEach((e1, e2) -> System.out.println(e1 + " " + e2));


        System.out.println();
        System.out.println();

        //Metodo summing per sommare!
        Map<String, Double> m5 = prodotti.stream().collect(Collectors.groupingBy(Prodotto::getCategoria, Collectors.summingDouble(Prodotto::getPrezzo)));
        m5.forEach(((e1, e2) -> System.out.println(e1 + " " + e2)));


        System.out.println();
        System.out.println();

       //Calcolo per la SOMMA di tutti i prezzi dei prodotti usando summingDouble di collect
        double somma = prodotti.stream().map(Prodotto::getPrezzo).collect(Collectors.summingDouble(Double::doubleValue));
        System.out.println(somma);


        System.out.println();
        System.out.println();

//Calcolo per la MEDIA di tutti i prezzi dei prodotti usando summingDouble di collect
        double media = prodotti.stream().map(Prodotto::getPrezzo).collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println(media);


        System.out.println();
        System.out.println();


        //Calcolo per la STATISTICA di tutti i prezzi dei prodotti usando summingDouble di collect
        DoubleSummaryStatistics stat = prodotti.stream().map(Prodotto::getPrezzo).collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println(stat);

        //In piu avendo creato una statistica summarizing mette a disposizione tutti i metodi precedentementi elencati perciò è molto comodo,
        // qui sotto stampo stat ed in piu aggiungo .getAverage per ottenere la media come se fosse il metodo .averagingDouble!!!!
        System.out.println(stat.getAverage());


        System.out.println();
        System.out.println();


        Map<Boolean, List<Prodotto>> m6 = prodotti.stream().collect(Collectors.partitioningBy(e -> e.getPrezzo() < 50));
        m6.forEach(((e1, e2) -> System.out.println(e1 + " " + e2)));

        System.out.println();
        System.out.println();

        //calcolo la somma dei prezzi di prodotti dello stream con reducing
        double somma2 = prodotti.stream().map(e -> e.getPrezzo()).collect(Collectors.reducing(0.0, ((aDouble, aDouble2) -> (aDouble + aDouble2.doubleValue()))));
        System.out.println(somma2);


        System.out.println();
        System.out.println();

        //ordino o stream di prodotti secondo l'ordine decrescente del prezzo, dicendo prima cosa comparare(getPrezzo) e come ordinarlo (reversed)
        prodotti.stream().sorted(Comparator.comparingDouble(Prodotto::getPrezzo).reversed()).forEach(System.out::println);

        System.out.println();
        System.out.println();

        //metodo mapToDouble, vado a stirngere ancora di più il codice e con mapTo ho ancora altri metodi disponibili tipo somma, ecc..
        double somma3 = prodotti.stream().mapToDouble(Prodotto::getPrezzo).sum();

        System.out.println(somma3);


        System.out.println();
        System.out.println();

        //Optional è una classe per contenere i risultato di un operazione, in modo che non ci torni null, in pià mapt
        OptionalDouble max = prodotti.stream().mapToDouble(Prodotto::getPrezzo).max();
        System.out.println(max.getAsDouble());




    }
}
