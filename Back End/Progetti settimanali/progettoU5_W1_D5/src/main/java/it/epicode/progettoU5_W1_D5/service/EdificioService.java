package it.epicode.progettoU5_W1_D5.service;

import it.epicode.progettoU5_W1_D5.beans.Edificio;
import it.epicode.progettoU5_W1_D5.beans.Prenotazione;
import it.epicode.progettoU5_W1_D5.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void inserisciEdificio(Edificio edificio){
        edificioRepository.save(edificio);

    }

    public  Edificio getPrenotazioneById(int codiceEdificio ){
        return edificioRepository.findById(codiceEdificio).get();
    }

    public List<Edificio> getEdifici(){
        return  edificioRepository.findAll();
    }

    public void cancellaEdificio(int codiceEdificio){
        edificioRepository.deleteById(codiceEdificio);
    }

}
