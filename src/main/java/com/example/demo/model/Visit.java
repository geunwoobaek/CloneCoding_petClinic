package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "visits")
public class Visit extends BaseEntity {

	// ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	Pet pet;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	private String description = null;

}
