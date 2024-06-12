package List;
import Object.Persona;
import java.util.ArrayList;

public class ProvaEquals {
    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<>();

        Persona persona1 = new Persona("Simone", "Castelluccio", 28);
        Persona persona2 = new Persona("Matteo", "Castelluccio", 30);
        Persona persona3 = new Persona("Mario", "Rossi", 18);


       //persona che non è stata isnerita nella lista, serve per il confronto.
        Persona persona4 = new Persona("Mario", "Rossi", 18);

        persone.add(persona1);
        persone.add(persona2);
        persone.add(persona3);

        System.out.println(persone);


        //Metodo contains VERIRIFICO se nella lista c'è qualcuno con i dati di persona 4
        // tramite l'ovveride il confronto avviene per dati e non per locazione di memoria!!!
        System.out.println(persone.contains(persona4));

        // metodo equals PARAGONO due oggetti
        System.out.println((persone.equals(persona4)));

    }
}
