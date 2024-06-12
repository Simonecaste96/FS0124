package ProvaSet;
import Object.Persona;

import java.util.Comparator;
import java.util.TreeSet;

public class ProvaSortedSet {

    public static void main(String[] args) {


        TreeSet<Persona> persone = new TreeSet<>(new Comparator<Persona>() {

            //Di DEFAULT non è stampabile il contenuto della lista, a meno che non facciamo io compare!
            //Aggiungendo sopra nell'istanza ---> new Comparator<Persona>()
            @Override
            public int compare(Persona o1,Persona o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        Persona persona1 = new Persona("Simone", "Castelluccio", 28);
        Persona persona2 = new Persona("Matteo", "Castelluccio", 30);


        Persona persona3 = new Persona("Simone", "Castelluccio", 28);



        //Inserisco le persone create nella lista TreeSet
        persone.add(persona1);
        persone.add(persona2);


        System.out.println(persone);
    }

}
