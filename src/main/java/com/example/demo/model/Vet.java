package com.example.demo.model;

import com.example.demo.model.comon.Person;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="vets")
@Data
public class Vet extends Person {
    @OneToMany(mappedBy = "vet")
    List<VetSpecialty> vetSpecialtiesList;

}
