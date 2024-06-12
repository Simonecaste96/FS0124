package it.epicode.U5_W1_D4.repository;

import it.epicode.U5_W1_D4.bean.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente,Integer> {



    // A DIFFERENZA DEI METODI, LE QUERY DEVONO ESSERE SCRITTE E POI RICHIAMATE IN STUDENTE SERVICE,
    // PERCHè NON SONO IMPLEMENTATE AUTOMATICAMENTE COME I METODI (SAVE,DELL.FINDBY ECC).
    public List<Studente> findByNomeAndCognome(String nome,String cognome);

   public List<Studente> findByNomeLike (String nome);


}
