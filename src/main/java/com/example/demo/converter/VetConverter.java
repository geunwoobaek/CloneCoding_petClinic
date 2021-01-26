package com.example.demo.converter;

import com.example.demo.model.Vet;
import com.example.demo.model.dto.VetDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VetConverter extends DtoConverter {

    @Override
    public Object ConvertToDto(Object Domain) {
        Vet vet = (Vet) Domain;
        VetDto vetDto = new VetDto().builder().firstName((vet).getFirstName()).lastName(vet.getLastName())
                .Specialties(vet.getVetSpecialtyList().stream().map(specialty -> specialty.getSpecialty().getName())
                        .collect(Collectors.toList()))
                .build();
        return vetDto;
    }

}
