package Object;

public class UsaPersona {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Simone", "Castelluccio", 28);

        Persona persona2 = new Persona("Simone", "Castelluccio", 28);

//Stampo persona 1, di default utilizza il metodo toString come nel secondo esempio
        System.out.println(persona1);
        //abbiamo fatto l'override di toString nella classe Persona perciò non è più default
        System.out.println(persona1.toString());

//Equals di DEFAULT (senza Override) comporta come ==, di fatto direbbe che è false,
// ma si trovano in due indirizzi di memoria differenti, in questo caso l'Override di equals ESISTE nella classe Persona!!
        System.out.println(persona1.equals(persona2));

        //Invece == continua ad avere il suo comportamento di DEFAULT confrontando indirizzi di memoria!!
        System.out.println(persona1 == persona2);


        //hashCode di DEFAULT (senza Override) comporta come ==, di fatto darebbe due numeri diversi,
        // perchè le istanze si trovano in due indirizzi di memoria differenti, in questo caso l'Override di hashCode ESISTE nella classe Persona!!
        System.out.println(persona1.hashCode());
        System.out.println(persona2.hashCode());


    }
}
