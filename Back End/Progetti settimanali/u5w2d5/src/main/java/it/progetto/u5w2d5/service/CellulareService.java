package it.progetto.u5w2d5.service;

import com.cloudinary.Cloudinary;
import it.progetto.u5w2d5.Dto.CellulareDto;
import it.progetto.u5w2d5.exception.DipendenteNonTrovatoException;
import it.progetto.u5w2d5.exception.DispositivoNonTrovatoException;
import it.progetto.u5w2d5.model.Cellulare;
import it.progetto.u5w2d5.model.Dipendente;
import it.progetto.u5w2d5.repository.CellulareRepository;
import it.progetto.u5w2d5.repository.DipendenteRepository;
import it.progetto.u5w2d5.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CellulareService {
    @Autowired
    CellulareRepository cellulareRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;
    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;


    public Optional<Cellulare> getCellulareById(int id) {

        return cellulareRepository.findById(id);
    }


    public String saveCellulare(CellulareDto cellulareDto) throws DispositivoNonTrovatoException {



        // Controllo se il dipendente associato al dispositivo esiste
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(cellulareDto.getDipendenteId());

        Cellulare cellulare = new Cellulare();

        if (!dipendenteOptional.isPresent()) {
            throw new DispositivoNonTrovatoException("Impossibile aggiungere il dispositivo se il dipendente con l'id inserito non esiste: aggiungi prima il dipendente ed inserisci il suo id");
        }else {

            cellulare.setMarca(cellulareDto.getMarca());
            cellulare.setModello(cellulareDto.getModello());
            cellulare.setColore(cellulareDto.getColore());
            cellulare.setMemoriaGb(cellulareDto.getMemoriaGb());
            cellulare.setStatoDispositivo(cellulareDto.getStatoDispositivo());
            cellulare.setTipoDispositivo(cellulareDto.getTipoDispositivo());
            cellulare.setDipendente(dipendenteOptional.get());


            // Salvo il dispositivo
            cellulareRepository.save(cellulare);

            // Invio la mail di conferma
            sendMailDispositivoAssociato(dipendenteOptional.get().getEmail());

            // Restituisco un messaggio di successo
            return "Dispositivo salvato con id: " + cellulare.getId()+"ed associato al dipendente con matricola: "+ cellulare.getDipendente().getId()+" Nome"+ cellulare.getDipendente().getNome()+" Cognome"+ cellulare.getDipendente().getCognome();
        }


    }





    public Cellulare updateCellulare(int id, CellulareDto cellulareDto) throws DispositivoNonTrovatoException, DipendenteNonTrovatoException {

        Optional<Cellulare> cellulareOpt = getCellulareById(id);

        if (cellulareOpt.isPresent()) {


            Cellulare cellulare = cellulareOpt.get();
            cellulare.setMarca(cellulareDto.getMarca());
            cellulare.setModello(cellulareDto.getModello());
            cellulare.setColore(cellulareDto.getColore());
            cellulare.setMemoriaGb(cellulareDto.getMemoriaGb());
            cellulare.setStatoDispositivo(cellulareDto.getStatoDispositivo());
            cellulare.setTipoDispositivo(cellulareDto.getTipoDispositivo());
            cellulare.setDipendente(cellulareOpt.get().getDipendente());


            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(cellulareDto.getDipendenteId());

            if(!dipendenteOptional.isPresent()){
                throw new DipendenteNonTrovatoException("Dipendente con id: " + id+ " non trovato");
            }
            else{
                cellulare.setDipendente(dipendenteOptional.get());
                System.out.println("Info dispositivo aggiornate con successo!");
                return cellulareRepository.save(cellulare);

            }
        }
        else{
            throw new DispositivoNonTrovatoException("Dispositivo con id: " + id+ " non trovato");
        }
    }



    private void sendMailDispositivoAssociato(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Dispositivo associato");
        message.setText("Il dispositivo è stato associato alla tua matricola");

        javaMailSenderImpl.send(message);
    }


}
