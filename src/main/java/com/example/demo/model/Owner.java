package com.example.demo.model;

import com.example.demo.model.comon.Person;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
@Data
public class Owner extends Person {

	@Embedded
	private OwnerInfo info;

	@OneToMany(mappedBy = "owner")
	private List<Pet> pets=new ArrayList<>();

	// 연관관계
	public void AddPet(Pet pet) {
		pets.add(pet);
		pet.setOwner(this);
	}

}
