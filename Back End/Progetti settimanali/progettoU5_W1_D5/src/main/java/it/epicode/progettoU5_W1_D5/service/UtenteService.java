package it.epicode.progettoU5_W1_D5.service;

import it.epicode.progettoU5_W1_D5.beans.Utente;
import it.epicode.progettoU5_W1_D5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
@Autowired
    private UtenteRepository utenteRepository;

public void inserisciUtente(Utente utente){
    utenteRepository.save(utente);
}

public Utente getUtenteById(int matricolaUtente){
   return  utenteRepository.findById(matricolaUtente).get();
}

    public List<Utente> getUtenti(){
        return  utenteRepository.findAll();
    }

    public void cancellaUtenteById(int matricolaUtente){
        utenteRepository.deleteById(matricolaUtente);
    }


}
