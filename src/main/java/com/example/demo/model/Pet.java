package com.example.demo.model;

import com.example.demo.model.common.NameEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

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

}
