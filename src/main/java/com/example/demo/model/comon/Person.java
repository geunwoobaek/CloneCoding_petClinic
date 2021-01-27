package com.example.demo.model.comon;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@Data
@MappedSuperclass
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {

	@Column(name = "first_name")
	@NotEmpty
	String firstName;

	@Column(name = "last_name")
	@NotEmpty
	String lastName;

	public void setFullName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
