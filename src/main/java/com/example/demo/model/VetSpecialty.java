package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class VetSpecialty extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vet_id")
	Vet vet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specialties_id")
	Specialty specialty;

}
