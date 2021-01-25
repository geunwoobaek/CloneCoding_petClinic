package com.example.demo.service;

import com.example.demo.model.Vet;
import com.example.demo.model.dto.VetDto;
import com.example.demo.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
@Transactional
public class VetService {
    private final VetRepository vetRepository;

    public List<VetDto> findAllList() {
        List<Vet> Vets=vetRepository.findAll();
        if (Vets == null) return emptyList();
        else
            return Vets.
                    stream().
                    map(vets -> new VetDto(vets.getFirstName() + vets.getLastName(),
                            vets.getVetSpecialtyList().
                                    stream().
                                    map(specialty -> specialty.getSpecialty().getName()).
                                    collect(Collectors.toList()))).
                    collect(Collectors.toList());
    }
    public void save(Vet vet) {
        vetRepository.save(vet);
    }
    public void PrintAll() {
        System.out.print("Vet:");
        vetRepository.findAll().stream().forEach(node -> System.out.println(node.getFirstName()));
        System.out.println();
    }
}
