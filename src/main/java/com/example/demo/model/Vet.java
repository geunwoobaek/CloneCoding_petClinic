package com.example.demo.model;

import com.example.demo.model.common.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="vets")
public class Vet extends Person {
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="vet_specialties",joinColumns = @JoinColumn(name="vet_id"),
    inverseJoinColumns = @JoinColumn(name="sepctiality_id"))
    private Set<Specialty> specialties;

    protected Set<Specialty> getSpecialtiesInternal(){
        if(this.specialties==null){
            this.specialties=new HashSet<>();
        }
        return this.specialties;
    }
    public void addSpecialty(Specialty specialty){
        this.getSpecialties().add(specialty);
    }

}
