package Esercizio;

import java.util.HashMap;
import java.util.Set;


public class Rubrica {


    HashMap<String, String> contatti = new HashMap<>();




    public void inserisciCoppia(String nome, String numero) {
        contatti.put(nome,numero);
    }

    public void cancellaCoppia(String nome){
        contatti.remove(nome);
    }

    public String ricercaPerNome(String nome){
        return contatti.get(nome);
    }

    public String cercaPerNumero(String numero){
        Set<String> nomi = contatti.keySet();
        for (String nome:nomi) {
            String numeroTelefono = contatti.get(nome);


          if(numeroTelefono.equals(numero)){
              return nome;
          }
        }
        return numero;
    }

}
