package com.example.demo.model;


import com.example.demo.model.common.Person;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction=0,integer=10)
    private String telephone;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="owner")
    private Set<Pet> pets;

}
