package com.example.demo.model;

import com.example.demo.model.comon.Person;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vets")
@Getter
public class Vet extends Person {

	@OneToMany(mappedBy = "vet",cascade = CascadeType.ALL)
	List<VetSpecialty> vetSpecialtyList = new ArrayList();

	public void addVetSpecialty(VetSpecialty vetSpecialty){
		vetSpecialtyList.add(vetSpecialty);
	}

}
