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
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    @Autowired
    DipendenteRepository dipendenteRepository;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;


    public Optional<Computer> getComputerById(int id) {

        return computerRepository.findById(id);
    }


    public String saveComputer(ComputerDto computerDto) throws DispositivoNonTrovatoException {



        // Controllo se il dipendente associato al dispositivo esiste
        Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(computerDto.getDipendenteId());

        Computer computer = new Computer();

        if (!dipendenteOptional.isPresent()) {
            throw new DispositivoNonTrovatoException("Impossibile aggiungere il dispositivo se il dipendente con l'id inserito non esiste: aggiungi prima il dipendente ed inserisci il suo id");
        }else {

            computer.setMarca(computerDto.getMarca());
            computer.setModello(computerDto.getModello());
            computer.setCpu(computerDto.getCpu());
            computer.setGbRam(computerDto.getGbRam());
            computer.setStatoDispositivo(computerDto.getStatoDispositivo());
            computer.setTipoDispositivo(computerDto.getTipoDispositivo());
            computer.setDipendente(dipendenteOptional.get());


            // Salvo il dispositivo
            computerRepository.save(computer);

            // Invio la mail di conferma
            sendMailDispositivoAssociato(dipendenteOptional.get().getEmail());

            // Restituisco un messaggio di successo
            return "Dispositivo salvato con id: " + computer.getId()+"ed associato al dipendente con matricola: "+ computer.getDipendente().getId()+" Nome dipendente: "+ computer.getDipendente().getNome()+" Cognome dipendente: "+ computer.getDipendente().getCognome();
        }


    }



    public Computer updateComputer(int id, ComputerDto computerDto) throws DispositivoNonTrovatoException, DipendenteNonTrovatoException {

        Optional<Computer> computerOpt = getComputerById(id);

        if (computerOpt.isPresent()) {


            Computer computer = computerOpt.get();
            computer.setMarca(computerDto.getMarca());
            computer.setModello(computerDto.getModello());
            computer.setCpu(computerDto.getCpu());
            computer.setGbRam(computerDto.getGbRam());
            computer.setStatoDispositivo(computerDto.getStatoDispositivo());
            computer.setTipoDispositivo(computerDto.getTipoDispositivo());
            computer.setDipendente(computerOpt.get().getDipendente());


            Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(computerDto.getDipendenteId());

            if(!dipendenteOptional.isPresent()){
                throw new DipendenteNonTrovatoException("Dipendente con id: " + id+ " non trovato");
            }
            else{
                computer.setDipendente(dipendenteOptional.get());
                System.out.println("Info dispositivo aggiornate con successo!");
                return computerRepository.save(computer);

            }
        }
        else{
            throw new DispositivoNonTrovatoException("Blog con id: " + id+ " non trovato");
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




