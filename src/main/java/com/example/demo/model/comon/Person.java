package com.example.demo.model.comon;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Person extends BaseEntity {

	String firstName;

	String lastName;

}
