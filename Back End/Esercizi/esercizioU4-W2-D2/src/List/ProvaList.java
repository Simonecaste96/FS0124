package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProvaList {
    public static void main(String[] args) {

        //Con i generics: <tipo elemento>, definisco il tipo del contenuto della lista!!
        /* Accetta duplicati, mantiene l'ordine della lista, lavora con gli indici*/
        ArrayList<String> lista = new ArrayList();

        //Con il metodo ADD aggiungiamo oggetti nella lista
        lista.add("10");
        lista.add("ciao");
        lista.add("Simone");
        lista.add("EPICODE");
        lista.add("ciao");


        //Con il metodo SET modifichiamo oggetti nella lista
        lista.set(2, "Ho modificato Simone con questa frase");


        //Con il metodo SIZE stampiano la dimensione della ArrayList(parte da 1 non da 0!)
        System.out.println(lista.size());

        //Con il metodo REMOVE rimuove elemento passando l'indice oppure il valore dell'elemento(se trovato)
        lista.remove(0); //rimozione per indice

        //Posso stampare direttamente la lista
        System.out.println(lista);

        lista.remove("ciao"); //rimozione per valore dell'oggetto del primo valore corrispondente
        System.out.println(lista.size());


        //Ristampo la lista dopo aver rimosso "ciao"
        System.out.println(lista);


        //Se serve CREARE RAPIDAMENTE UNA LISTA
        System.out.println(List.of("Ho","creato","una","lista","rapida"));



        //Con il metodo isEmpty ci dice se la lista è piena o vuota, restituendo true o false
        System.out.println(lista.isEmpty());

        //Con il metodo contains ricerco una stringa specifica, restituisce true o false
        System.out.println(lista.contains("EPICODE"));
        System.out.println(lista.contains("Alberto"));


        System.out.println(lista.indexOf("ciao"));




        //Classe LinkedList e uguale ad ArayList ma in più si aggiunge la logica della queue(coda)
        LinkedList<String> lista2 = new LinkedList<>();

        lista2.add("Luca");
        lista2.add("Vincenzo");
        lista2.add("Stefano");
        lista2.add("Simone");
        System.out.println(lista2);

        //Il metodo POLL rimuove l'elemento IN TESTA della queue, e lo restituisce, perciò si potrebbe inserire dentro un altra lista.
        lista2.poll();
        //Ristampo la lista dopo aver usato il metodo POLL
        System.out.println(lista2);


    }
}
