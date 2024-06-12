package it.epicode.u5w2d2esercizio.service;

import com.cloudinary.Cloudinary;
import it.epicode.u5w2d2esercizio.Dto.AutoreDto;
import it.epicode.u5w2d2esercizio.exception.AutoreNonTrovatoException;
import it.epicode.u5w2d2esercizio.exception.BlogNonTrovatoException;
import it.epicode.u5w2d2esercizio.model.Autore;
import it.epicode.u5w2d2esercizio.model.Blog;
import it.epicode.u5w2d2esercizio.repository.AutoreRepository;
import it.epicode.u5w2d2esercizio.repository.BlogRepository;
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
import java.util.*;

@Service
public class AutoreService {

   // private List<Autore> autors = new ArrayList<>();


    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;
    public Optional<Autore> getAutoreById(int id){
        return autoreRepository.findById(id);
    }


    public Page<Autore> getAllAutori(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return  autoreRepository.findAll(pageable);
    }

    public String saveAutore(AutoreDto autoreDto){
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setDataNascita(autoreDto.getDataNascita());
        autore.setEmail(autoreDto.getEmail());
        autore.setAvatar("https://ui-avatars.com/api/?name="+autore.getNome()+"+"+autore.getCognome());
        autoreRepository.save(autore);
        sendMail(autore.getEmail());
        return "Autore creato, id: " + autore.getId();
    }

    public Autore updateAutore(Autore blogUpdate, int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(blogUpdate.getNome());
            autore.setCognome(blogUpdate.getCognome());
            autore.setEmail(blogUpdate.getEmail());
            autore.setDataNascita(blogUpdate.getDataNascita());
            return autoreRepository.save(autore);
        } else {
            throw new AutoreNonTrovatoException("Nessun autore non trovato con il seguente id: "+ id);
        }
    }


    public Autore updateAutoreParse(int id, Map<String, Object> update) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);
        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();

            update.forEach((key, value) -> {
                switch (key) {
                    case "nome":
                        autore.setNome((String) value);
                        break;
                    case "cognome":
                        autore.setCognome((String) value);
                        break;
                    case "email":
                        autore.setEmail((String) value);
                        break;
                    case "dataNascita":
                        autore.setDataNascita((LocalDate) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Campo non valido: " + key);
                }
            });

            autoreRepository.save(autore);

            return autore;
        } else {
            throw new AutoreNonTrovatoException("Nessun autore trovato con id: " + id);
        }
    }



    public String deleteAutore(int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            autoreRepository.delete(autoreOpt.get());
            return "Autore con id="+ id + " eliminato";
        } else {
            throw new AutoreNonTrovatoException("Nessun autore trovato con id: "+id);
        }


    }



    public String patchAvatarAutore(int id, MultipartFile foto) throws AutoreNonTrovatoException, IOException {
        Optional<Autore> autoreOptional = getAutoreById(id);
        if (autoreOptional.isPresent()){
            String url =(String) cloudinary.uploader().upload(foto.getBytes(), Collections.emptyMap()).get("url");
            Autore autore = autoreOptional.get();
            autore.setAvatar(url);
            autoreRepository.save(autore);
            return "Immagine profilo salvata!";
        }else{
            throw new AutoreNonTrovatoException("Impossibile impostare immagine del profilo, non è stato trovato nessun autore con id : "+id);
        }
    }




    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione avvenuta con successo");
        message.setText("Registrazione avvenuta con successo!");

        javaMailSenderImpl.send(message);
    }


}
