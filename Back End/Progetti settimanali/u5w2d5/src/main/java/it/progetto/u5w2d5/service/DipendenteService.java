package it.progetto.u5w2d5.service;

import com.cloudinary.Cloudinary;
import it.progetto.u5w2d5.Dto.DipendenteDto;
import it.progetto.u5w2d5.exception.DipendenteNonTrovatoException;
import it.progetto.u5w2d5.model.Dipendente;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DipendenteService {



    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;
    public Optional<Dipendente> getDipendenteById(int id){
        return dipendenteRepository.findById(id);
    }


    public Page<Dipendente> getDipendentiConPaginazione(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return  dipendenteRepository.findAll(pageable);
    }
    public List<Dipendente> getDipendenti(){
        return  dipendenteRepository.findAll();
    }

    public String saveDipendente(DipendenteDto dipendenteDto){
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome(dipendenteDto.getCognome());
        dipendente.setEmail(dipendenteDto.getEmail());
        dipendenteRepository.save(dipendente);
        sendMailCreazioneProfilo(dipendente.getEmail());
        return "Dipendente aggunto, id: " + dipendente.getId();
    }

    public Dipendente updateDipendente(Dipendente dipendenteUpdate, int id) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOpt = getDipendenteById(id);
        if (dipendenteOpt.isPresent()) {
            Dipendente dipendente = dipendenteOpt.get();
            dipendente.setUsername(dipendenteUpdate.getUsername());
            dipendente.setNome(dipendenteUpdate.getNome());
            dipendente.setCognome(dipendenteUpdate.getCognome());
            dipendente.setEmail(dipendenteUpdate.getEmail());
            return dipendenteRepository.save(dipendente);
        } else {
            throw new DipendenteNonTrovatoException("Non risulta nessun dipendente con il seguente id: "+ id);
        }
    }


    public Dipendente updateDipendenteParse(int id, Map<String, Object> update) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOpt = getDipendenteById(id);
        if (dipendenteOpt.isPresent()) {
            Dipendente dipendente = dipendenteOpt.get();

            update.forEach((key, value) -> {
                switch (key) {
                    case "username":
                        dipendente.setUsername((String) value);
                        break;
                    case "nome":
                        dipendente.setNome((String) value);
                        break;
                    case "cognome":
                        dipendente.setCognome((String) value);
                        break;
                    case "email":
                        dipendente.setEmail((String) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo non valido: " + key);
                }
            });

            dipendenteRepository.save(dipendente);

            return dipendente;
        } else {
            throw new DipendenteNonTrovatoException("Nessun dipendente trovato con id: " + id);
        }
    }



    public String deleteDipendente(int id) throws DipendenteNonTrovatoException {
        Optional<Dipendente> dipendenteOpt = getDipendenteById(id);

        if (dipendenteOpt.isPresent()) {
            dipendenteRepository.delete(dipendenteOpt.get());
            return "Dipendente con matricola: "+ id + " eliminato dal database";
        } else {
            throw new DipendenteNonTrovatoException("Nessun dipendente trovato con matricola: "+id);
        }


    }



    public String patchImmagineProfiloDipendente(int id, MultipartFile foto) throws DipendenteNonTrovatoException, IOException {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);
        if (dipendenteOptional.isPresent()){
            String url =(String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setImmagineProfilo(url);
            dipendenteRepository.save(dipendente);
            return "Immagine profilo aggiornata!";
        }else{
            throw new DipendenteNonTrovatoException("Impossibile impostare immagine del profilo, non è stato trovato nessun dipendente con matricola: "+id);
        }
    }




    private void sendMailCreazioneProfilo(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Dipendente aggiunto al database con successo");
        message.setText("Dipendente aggiunto con successo!");

        javaMailSenderImpl.send(message);
    }


}
