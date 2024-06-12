public class UsoPersona {


    public static void main(String[] args) {

        /* richiamo la classe persona, persona è il nome della classe,
         Persona() è il costruttore nel quale vado a definire i valori delle proprietà*/


        Persona persona = new Persona("Simone","Castelluccio",28,TipoLavoro.PROGRAMMATORE);
        //stampo in console.
        System.out.println(persona.nome);
        System.out.println(persona.cognome);
        System.out.println(persona.eta);

        System.out.println("Contatore persone create: "+persona.contatore);

        Persona persona2 = new Persona("Ajeje","Brazorf");
        System.out.println(persona2.nome);
        System.out.println(persona2.cognome);
        System.out.println(persona2.eta);


        System.out.println("Contatore persone create: "+persona2.contatore);



        /* scrivendo persona = null --> costringiamo java a cancellare
         l'indirizzo di memoria all'interno, rendendo irraggiungibile l'oggetto Ajeje Brazorf */
        persona=null;


        //persona prende l'indirizzo di memoria di persona 2
        persona=persona2;

        //sovrascrivo il nome di persona
        persona.nome="Matteo";

        /*stampo persona, il nome è cambiato, il cognome anche perchè ho sovrascritto la memoria
        con quella di persona 2*/
        System.out.println("Stampo persona, il nome è cambiato ma anche il cognome perchè ho sovrascritto la memoria con quella di persona 2");
        System.out.println(persona.nome);
        System.out.println(persona.cognome);

        //se cancello indirizzo di memoria di persona2
        persona2=null;

        //e vado a stampare il nome di persona
        System.out.println("Il nome di persona è: "+persona.nome);
        //se vado a stamapre in nome di persona2 sarà null
        //System.out.println("Il nome di persona2 è: "+persona2.nome);



        /*gli oggetto possono essere confrontati tra di loro con equals oppure ==
        */
        System.out.println(persona==persona2);

        System.out.println(persona.equals(persona2));


    }
}
