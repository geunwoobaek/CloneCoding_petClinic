package com.example.demo.model;

import com.example.demo.model.comon.Person;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
@Data
public class Vet extends Person {

	@OneToMany(mappedBy = "vet", cascade = CascadeType.ALL)
	@BatchSize(size = 100)
	Set<VetSpecialty> vetSpecialtyList = new HashSet<>();

	// 연관관계 메서드
	public void addVetSpecialty(VetSpecialty vetSpecialty) {
		vetSpecialtyList.add(vetSpecialty);
	}

	//

}
