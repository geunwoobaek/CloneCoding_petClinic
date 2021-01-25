package com.example.demo.service;

import com.example.demo.model.Specialty;
import com.example.demo.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public void save(Specialty specialty) {
        if (specialtyRepository.findByName(specialty.getName()) == null)
            specialtyRepository.save(specialty);
    }

//    public Specialty get(String name) {
//        return specialtyRepository.findByName(name);
//    }
    public void PrintAll() {
        System.out.print("Specialty:");
        specialtyRepository.findAll().stream().forEach(node -> System.out.print(node.getName()));
        System.out.println();
    }
}
