package com.example.demo.model;

import com.example.demo.model.comon.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owners")
public class Owner extends Person {

	@Embedded
	private OwnerInfo info;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Pet> pets = new HashSet<>();

	// 연관관계
	public void AddPet(Pet pet) {
		pets.add(pet);
		pet.setOwner(this);
	}
	// @Override
	// public String toString() {
	// return new ToStringCreator(this)
	//
	// .append("id", this.getId()).append("new", this.isNew()).append("lastName",
	// this.getLastName())
	// .append("firstName", this.getFirstName()).append("address",
	// this.getInfo().address).append("city", this.getInfo().city)
	// .append("telephone", this.getInfo().telephone).toString();
	// }

}
