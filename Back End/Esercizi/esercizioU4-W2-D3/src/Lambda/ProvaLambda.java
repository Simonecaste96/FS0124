package Lambda;

import java.util.TreeSet;

public class ProvaLambda {
    public static void main(String[] args) {
       //Creo un istanza del comparatore
        Comparatore comparatore = new Comparatore();



        //Passo come parametro di TreeSet, l'istanza di comparatore creata sopra, in modo che l'ordine venga
        // cambiato in base al metodo compare, che si trova nella classe Comparatore
        //Di default nele liste SET, l'ordine viene fatto in maniera crescente/alfabetica;
        TreeSet<String> parole = new TreeSet<>(comparatore);

        parole.add("Java");
        parole.add("HTML");
        parole.add("JavaScript");
        parole.add("Angular");

        System.out.println(parole);

//QUESTA COMPARATO PERO HA UN LIMITE, NON è APPLICABILE AD OGNI CONTESTO, DOVREI CRARE UN COMPARATORE DIVERSO PER OGNI VOLTA
    }
}
