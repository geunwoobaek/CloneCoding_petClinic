package com.example.demo.model;


import com.example.demo.model.common.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="visits")
public class Visit extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @Column(name="visit_date")
    private LocalDate date;

    @Column(name="description")
    private String description;
}
