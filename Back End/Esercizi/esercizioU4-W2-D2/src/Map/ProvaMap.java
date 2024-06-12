package Map;

import java.util.HashMap;
import java.util.Set;

import Object.Persona;

public class ProvaMap {
    public static void main(String[] args) {

        //Dobbiamo insirire due parametri, (CHIAVE --> String, Persona)
        HashMap<String, Persona> anagrafe = new HashMap<>();

        Persona persona1 = new Persona("Simone", "Castelluccio", 28);
        Persona persona2 = new Persona("Matteo", "Castelluccio", 30);


//Se una persona ha la stessa chiave di un altra, va a sovrascrive, IL DUPLICATO di persona2 non verrà stampata
        anagrafe.put("CSTSMN96L16H501X", persona1);
        anagrafe.put("CSTMTT93R09H501Z", persona2);
        anagrafe.put("CSTMTT93R09H501Z", persona2);


        //Ricerca tramite CHIAVE
        System.out.println(anagrafe.get("CSTSMN96L16H501X"));


        //Creo un set di CHIAVI  (CHIAVE --> String, Persona)
        Set<String> cf = anagrafe.keySet();

        //Non esiste un metodo per ricercare una persona specifica, ma questo algoritmo riesce tramite la persona,
        // ad arrivare al codice fiscale
        /*Questo algoritmo permette di effettuare la ricerca confrontando la persona con i set di chiavi, praticamente il contrario di come funziona HashMap il quale
        per effettuare la ricerca PRETENDE solo la CHIAVE*/
        for(String chiave:cf){
            Persona p = anagrafe.get(chiave);

            if(p==persona1){
                System.out.println(chiave);
            }
        }




        System.out.println(anagrafe);
        System.out.println(anagrafe.get("CSTSMN96L16H501X"));
    }
}
