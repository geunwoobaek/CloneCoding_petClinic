package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialty extends BaseEntity {
    String name;
    @OneToMany(mappedBy = "specialty")
    List<VetSpecialty> vetSpecialtyList = new ArrayList();
}
