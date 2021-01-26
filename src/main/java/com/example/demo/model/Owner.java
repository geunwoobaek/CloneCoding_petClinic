package com.example.demo.model;

import com.example.demo.model.comon.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
@Getter
@NoArgsConstructor
public class Owner extends Person {

	@Embedded
	private OwnerInfo info;

	@OneToMany(mappedBy = "owner")
	private List<Pet> pets = new ArrayList<>();

	// 연관관계
	public void AddPet(Pet pet) {
		pets.add(pet);
		pet.setOwner(this);
	}
	@Builder
	public Owner(OwnerInfo info,List<Pet> pets){
	this.info=info;
	this.pets=pets;
	}

}
