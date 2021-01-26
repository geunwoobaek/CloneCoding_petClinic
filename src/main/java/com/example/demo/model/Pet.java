package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "pets")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Pet extends BaseEntity {

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate birthDate;

	@OneToMany
	@JoinColumn(name = "visit_id")
	List<Visit> visits = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "type_id")
	private Type type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "onwer_id")
	private Owner owner = null;

	// 연관관계매핑
	public void setType(Type type) {
		type.AddPet(this);
		this.type = type;
	}

}
