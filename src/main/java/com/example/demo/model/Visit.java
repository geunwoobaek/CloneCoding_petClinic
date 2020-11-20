package com.example.demo.model;


import com.example.demo.model.common.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="visits")
public class Visit extends BaseEntity {

    @JoinColumn(name="pet_id")
    private Integer petId;

    @Column(name="visit_date")
    private LocalDate date;
    @NotEmpty
    @Column(name="description")
    private String description;
}
