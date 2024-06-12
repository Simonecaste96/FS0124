package Lambda;

import java.util.Comparator;
//QUESTA è UN INTERFACCIA FUNZIONALE, HA SOLTANTO UN METODO!!!!!

//Ho isnserito string nel comparatort per definire il tipo di dati da comparare
public class Comparatore implements Comparator<String> {


    //shortcut per creare metodo compare, alt+ins --> compare
    @Override
    public int compare(String o1, String o2) {
        //01==o2(restituisce 0) /
        // se o2 viene prima di o1, restituise un numero negativo
        // se o1 viene prima di o2, restituisce un numero positivi
        return o2.compareTo(o1);
    }
}
