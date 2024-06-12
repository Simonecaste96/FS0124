package it.epicode.U5_W1_D4.service;

import it.epicode.U5_W1_D4.bean.Studente;
import it.epicode.U5_W1_D4.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteService {

@Autowired
    private StudenteRepository studenteRepository;

public void inserisciStudente(Studente studente){
    studenteRepository.save(studente);
}



public Studente getStudente(int matricola){
    return  studenteRepository.findById(matricola).get();
}



public List<Studente> getStudenti(){
    return studenteRepository.findAll();
}


public void cancellaStudente(int matricola){
    studenteRepository.deleteById(matricola);
}

public List<Studente> getStudentiByNomeAndCognome(String nome,String cognome){
    return  studenteRepository.findByNomeAndCognome(nome,cognome);
};


public List<Studente> getNomeByLike(String nome){
    return studenteRepository.findByNomeLike(nome);
}
}
