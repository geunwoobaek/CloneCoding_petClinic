package com.example.demo.model.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OwnerDto {

	private String firstName;

	private String lastName;

	private List<String> pets;

	@QueryProjection
	@Builder
	public OwnerDto(String firstName, String lastName, List<String> pets) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pets = pets;
	}

}
