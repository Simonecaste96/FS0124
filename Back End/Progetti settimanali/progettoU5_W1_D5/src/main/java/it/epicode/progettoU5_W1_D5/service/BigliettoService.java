package it.epicode.progettoU5_W1_D5.service;

import it.epicode.progettoU5_W1_D5.beans.Biglietto;
import it.epicode.progettoU5_W1_D5.beans.Utente;
import it.epicode.progettoU5_W1_D5.repository.BigliettoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BigliettoService {
    @Autowired
    BigliettoRepository bigliettoRepository;

    public void inserisciBiglietto(Biglietto biglietto){
        boolean verificaSoldOut = getBiglietti().stream()
                .allMatch(e -> e.getIdEvento().getListaBiglietti().size() == e.getIdEvento().getPostazionePrenotata().getNumeroMaxPartecipanti());

        if(!verificaSoldOut){
            bigliettoRepository.save(biglietto);
        }else{
            System.out.println("*****NUMERO MASSIMO DI PRENOTAZIONI RAGGIUNTO****");
        }

    }

    public Biglietto getBigliettoByUUID(UUID uuidBiglietto){
        return  bigliettoRepository.findById(uuidBiglietto).get();
    }

    public List<Biglietto> getBiglietti(){
        return  bigliettoRepository.findAll();
    }

    public void cancellaBigliettoByUUID(UUID uuidBiglietto){
        bigliettoRepository.deleteById(uuidBiglietto);
    }
}
