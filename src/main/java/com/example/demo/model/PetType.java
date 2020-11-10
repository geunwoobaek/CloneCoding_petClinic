package com.example.demo.model;

import com.example.demo.model.common.NameEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="types")
public class PetType extends NameEntity {
}
