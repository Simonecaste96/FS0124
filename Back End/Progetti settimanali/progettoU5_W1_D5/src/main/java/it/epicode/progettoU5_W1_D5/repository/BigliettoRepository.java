package it.epicode.progettoU5_W1_D5.repository;

import it.epicode.progettoU5_W1_D5.beans.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BigliettoRepository extends JpaRepository<Biglietto, UUID> {
}
