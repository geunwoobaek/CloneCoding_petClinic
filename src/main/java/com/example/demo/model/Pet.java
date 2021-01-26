package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="pets")
public class Pet extends BaseEntity {

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate birthDate;

	@OneToMany
	@JoinColumn(name = "visit_id")
	List<Visit> visits = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private Type type = null;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "onwer_id")
	private Owner owner = null;

	// 연관관계매핑
	public void setType(Type type) {
		this.type = type;
		type.getPets().add(this);
	}

}
