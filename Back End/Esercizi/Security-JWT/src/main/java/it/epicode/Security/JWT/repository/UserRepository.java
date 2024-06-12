package it.epicode.Security.JWT.repository;

import it.epicode.Security.JWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

public Optional<User> findByEmail(String email); // resitutiamo un optional perchè non sappiamo se c'è effettivamene e lo grstiamo come vvogliamo


}
