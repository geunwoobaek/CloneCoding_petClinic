package com.example.demo.model;

import com.example.demo.model.common.NameEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Pet extends NameEntity {
    @Column(name="birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Transient
    private Set<Visit> visits = new LinkedHashSet<>();

    public void addVisit(Visit visit) {
        this.getVisits().add(visit);
        visit.setPetId(this.getId());
    }
}
