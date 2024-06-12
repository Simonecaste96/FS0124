package ProvaSet;
import Object.Persona;
import java.util.ArrayList;
import java.util.HashSet;

public class ProvaSet {
    public static void main(String[] args) {


        //Non accetta duplicati, ordine != ordine di inserimento, NON lavora ha indici!!!
        //Puo essere destrutturato SOLO CON IL FOR AVANZATO
        HashSet<Persona> persone = new HashSet<>();

        Persona persona1 = new Persona("Simone", "Castelluccio", 28);
        Persona persona2 = new Persona("Matteo", "Castelluccio", 30);


        Persona persona3 = new Persona("Simone", "Castelluccio", 28);



       //Inserisco le persone create nella lista HashSet
    persone.add(persona1);
    persone.add(persona2);

    //La stampo
        System.out.println(persone);
//Ora aggiungo persona3
        persone.add(persona3);
        //ADD ritorna un booleano, infaatti se stamo darà come risultato false,poichè già c'è una "persona" con gli stessi dati!
        System.out.println(persone.add(persona3));
//Ristampo, la persona non è stata aggiunta perchè il sistema di DEFAULT non aggiunge duplicati della stessa persona!!!
        System.out.println(persone);
        System.out.println();
        //Destrutturo con il forEach
        System.out.println("---------Destrutturo con il forEach-------");
        for(Persona p:persone){
            System.out.println(p);
        }
    }


}
