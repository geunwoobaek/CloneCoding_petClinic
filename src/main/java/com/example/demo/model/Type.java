package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name="types")
public class Type extends BaseEntity {

	private String name;

	@OneToMany(mappedBy = "type")
	List<Pet> pets;

}
