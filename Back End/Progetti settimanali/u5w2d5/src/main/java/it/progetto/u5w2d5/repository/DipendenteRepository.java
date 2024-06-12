package it.progetto.u5w2d5.repository;


import it.progetto.u5w2d5.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente,Integer> {
}
