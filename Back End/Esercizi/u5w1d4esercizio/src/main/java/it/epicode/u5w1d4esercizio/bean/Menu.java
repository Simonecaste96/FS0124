package it.epicode.u5w1d4esercizio.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Menu {

    @Id
    @GeneratedValue
    private int id;
    @Autowired
private List<Drink> bevande;
    @Autowired
private List<Antipasti> antipasti;
    @Autowired
private List<Pizze> pizze;
    @Autowired
private List<Topping> topping;


}

