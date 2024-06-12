package it.epicode.Security.JWT.service;

import it.epicode.Security.JWT.dto.UserDto;
import it.epicode.Security.JWT.entity.User;
import it.epicode.Security.JWT.exception.UserNotFoundException;
import it.epicode.Security.JWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


//con questo metodo accediamo al repository, cerchiamo un utente con un email, se ce lo restituiamo altrimenti eccezione
  public User getUserByEmail(String email){
     Optional<User> userOptional =  userRepository.findByEmail(email);

      if (userOptional.isPresent()) {
          return userOptional.get();
      }else{
          throw new UserNotFoundException("User with email: "+email+" not found");
      }
  }


    public String saveUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

       userRepository.save(user);

       return "User with id: "+ user.getId()+ " correctly saved";

    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }


    public Optional<User> getUserById(int id){
     return  userRepository.findById(id);
    }

    public User updateUser(int id, UserDto userDto) throws UserNotFoundException{
        Optional<User> userOptional = getUserById(id);
        if(userOptional.isPresent()){

            User user = userOptional.get();
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());

            return userRepository.save(user);

        }else{
            throw new UserNotFoundException("User with id: "+id+" not found");
        }

    }


    public String deleteUser(int id){
        Optional<User> userOptional = getUserById(id);

        if(userOptional.isPresent()){

            userRepository.deleteById(id);
            return "User with id: "+ id+ " correctly deleted";

        }else{
            throw new UserNotFoundException("User with id: "+id+" not found");
        }
    }

}
