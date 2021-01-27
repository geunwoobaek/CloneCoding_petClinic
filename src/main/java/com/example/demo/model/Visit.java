package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
@Data
public class Visit extends BaseEntity {

	public Visit() {
		this.date = LocalDate.now();
	}

	@Column(name = "visit_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@NotEmpty
	@Column(name = "description")
	private String description;

	@Column(name = "pet_id")
	private Long petId;

}
