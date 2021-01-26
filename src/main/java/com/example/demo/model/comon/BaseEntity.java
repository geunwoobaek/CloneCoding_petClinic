package com.example.demo.model.comon;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public class BaseEntity {

	@Id
	@GeneratedValue
	Long id;

	public boolean isNew() {
		return this.id == null;
	}

}
