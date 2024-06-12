package it.epicode.progettoU5_W1_D5.service;

import it.epicode.progettoU5_W1_D5.beans.Postazione;
import it.epicode.progettoU5_W1_D5.beans.Prenotazione;
import it.epicode.progettoU5_W1_D5.enums.Tipo;
import it.epicode.progettoU5_W1_D5.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void inserisciPostazione(Postazione postazione){
        postazioneRepository.save(postazione);

    }

    public  Postazione getPostazioneById(int codicePostazione ){
        return postazioneRepository.findById(codicePostazione).get();
    }

    public List<Postazione> getPostazioni(){
        return  postazioneRepository.findAll();
    }

    public void cancellaPostazioni(int codicePostazioni){
        postazioneRepository.deleteById(codicePostazioni);
    }

    public List<Postazione>getfindByTipoAndCitta(Tipo tipo,String citta){
        return postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipo, citta);
    }
}
