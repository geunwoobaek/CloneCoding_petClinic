package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="specialties")
@Data
public class Specialty extends BaseEntity {

	String name;

	@OneToMany(mappedBy = "specialty",cascade = CascadeType.ALL)
	List<VetSpecialty> vetSpecialtyList = new ArrayList();

	public void addVetSpecialty(VetSpecialty vetSpecialty){
		vetSpecialtyList.add(vetSpecialty);
	}

}
