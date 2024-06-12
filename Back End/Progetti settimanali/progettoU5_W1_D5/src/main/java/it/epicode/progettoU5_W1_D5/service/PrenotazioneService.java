package it.epicode.progettoU5_W1_D5.service;
import it.epicode.progettoU5_W1_D5.beans.Prenotazione;
import it.epicode.progettoU5_W1_D5.repository.PrenotazioneRepository;
import it.epicode.progettoU5_W1_D5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;


@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void inserisciPrenotazione(Prenotazione prenotazione){//,int matricolaUtente rimetti matricola dentro se serve
        boolean verificaDisponiblitaSala =  getPrenotazioni().stream().anyMatch(e->e.getDataPrenotazione().equals(prenotazione.getDataPrenotazione()));
        boolean verificaPrenotazioniUtente = getPrenotazioni().stream()
                .anyMatch(p -> p.getPrenotataDa().equals(prenotazione.getPrenotataDa())
                        && p.getDataPrenotazione().isEqual(prenotazione.getDataPrenotazione()));


        if(!verificaPrenotazioniUtente && !verificaDisponiblitaSala)
        prenotazioneRepository.save(prenotazione);

        else if(verificaPrenotazioniUtente){
            System.out.println();
            System.out.println();
            System.out.println("*******Non puoi prenotare più di una sala nella stessa data!!****");
            System.out.println();
            System.out.println();
        }

        else{


            System.out.println();
            System.out.println();
            System.out.println("*******Sala prenotata in questa data!!****");
            System.out.println();
            System.out.println();
        }

    }

    public  Prenotazione getPrenotazioneById(int codicePrenotazione ){
        return prenotazioneRepository.findById(codicePrenotazione).get();
    }

    public List<Prenotazione> getPrenotazioni(){
        return  prenotazioneRepository.findAll();
    }

    public List<Prenotazione> getPrenotazioniUtente(int matricolaUtente){
        return prenotazioneRepository.findById(matricolaUtente).get().getPrenotataDa().getListaPrenotazioni();
    }
    public void cancellaPrenotazione(int codicePrenotazione){
        prenotazioneRepository.deleteById(codicePrenotazione);
    }
}
