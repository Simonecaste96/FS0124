package it.progetto.u5w2d5.service;

import com.cloudinary.Cloudinary;
import it.progetto.u5w2d5.Dto.CellulareDto;
import it.progetto.u5w2d5.Dto.ComputerDto;
import it.progetto.u5w2d5.Dto.DispositivoDto;
import it.progetto.u5w2d5.enums.TipoDispositivo;
import it.progetto.u5w2d5.exception.DipendenteNonTrovatoException;
import it.progetto.u5w2d5.exception.DispositivoNonTrovatoException;
import it.progetto.u5w2d5.model.Cellulare;
import it.progetto.u5w2d5.model.Computer;
import it.progetto.u5w2d5.model.Dipendente;
import it.progetto.u5w2d5.model.Dispositivo;
import it.progetto.u5w2d5.repository.CellulareRepository;
import it.progetto.u5w2d5.repository.ComputerRepository;
import it.progetto.u5w2d5.repository.DipendenteRepository;
import it.progetto.u5w2d5.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;


@Service
public class DispositivoService {


    @Autowired
    private DispositivoRepository dispositivoRepository;



    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;



    // ho lasciato solo il metodo DELETE, in comune per le varie classi

    public Optional<Dispositivo> getDispositivoById(int id) {

        return dispositivoRepository.findById(id);
    }

    public Page<Dispositivo> getDispositiviConPaginazione(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return dispositivoRepository.findAll(pageable);
    }



    public String deleteDispositivo (int id) throws DispositivoNonTrovatoException {
            Optional<Dispositivo> dispositivoOpt = getDispositivoById(id);

            if (dispositivoOpt.isPresent()) {
                dispositivoRepository.delete(dispositivoOpt.get());
                sendMailDispositivoRimosso(dispositivoOpt.get().getDipendente().getEmail());
                return "Dispositivo con id: "+ id + " è stato eliminato dal database";
            } else {
                throw new DispositivoNonTrovatoException("Dispositivo non trovato");
            }

        }


    private void sendMailDispositivoRimosso(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Dispositivo eliminato");
        message.setText("Il dispositivo è stato eliminato e dissociato dalla tua matricola");

        javaMailSenderImpl.send(message);
    }


    }



