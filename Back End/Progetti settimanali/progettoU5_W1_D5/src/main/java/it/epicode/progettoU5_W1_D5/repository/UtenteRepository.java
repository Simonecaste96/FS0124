package it.epicode.progettoU5_W1_D5.repository;

import it.epicode.progettoU5_W1_D5.beans.Postazione;
import it.epicode.progettoU5_W1_D5.beans.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente,Integer> {

}
