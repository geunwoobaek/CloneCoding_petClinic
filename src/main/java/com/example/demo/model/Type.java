package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "types")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "type",cascade = CascadeType.ALL)
    List<Pet> pets = new ArrayList<>();

    //연관관계메서드
    public void AddPet(Pet pet) {
    	if(pets==null) pets = new ArrayList<>();
        pets.add(pet);
    }
}
