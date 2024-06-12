package it.epicode.progetto_settimanale.gestione_eventi.Repository;

import it.epicode.progetto_settimanale.gestione_eventi.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);
}
