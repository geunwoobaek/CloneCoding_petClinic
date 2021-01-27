package com.example.demo.converter;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.model.dto.OwnerDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OwnerConverter extends DtoConverter {

	@Override
	public Object DomainToDto(Object Domain) {
		Owner owner = (Owner) Domain;
		OwnerDto ownerDto = new OwnerDto().builder().firstName((owner).getFirstName()).lastName(owner.getLastName())
				.pets(owner.getPets().stream().map(pets -> pets.getName()).collect(Collectors.toList())).build();
		return ownerDto;
	}

	@Override
	public Object DtoToDomain(Object Dto) {
		OwnerDto ownerdto = (OwnerDto) Dto;
		Owner owner = new Owner();
		owner.setFullName(((OwnerDto) Dto).getFirstName(),((OwnerDto) Dto).getLastName());
		ownerdto.getPets().
				stream().
				forEach(pet->owner.
						AddPet(new Pet().builder().name(pet).
								build()));
		return owner;
	}

}
