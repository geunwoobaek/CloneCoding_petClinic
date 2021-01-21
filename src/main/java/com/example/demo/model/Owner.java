package com.example.demo.model;

import com.example.demo.model.comon.Person;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="owners")
@Data
public class Owner extends Person {
    @Embedded
    private OwnerInfo info;
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    //연관관계
    public void AddPet(Pet pet){
        pets.add(pet);
        pet.setOwner(this);
    }
}
