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
    private LocalDate BirthDate;

    @JoinColumn(name="type_id")
    @ManyToOne
    private int type_id;

    @JoinColumn(name="owner_id")
    @ManyToOne
    private int owner_id;

}
