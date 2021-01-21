package com.example.demo.service;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public void addPet(Pet pet){
        petRepository.save(pet);
    }
    public List<Pet> findByPetsName(String name){
       // return petRepository.findAllByName(name).forEach(o->map(name));
    }
}
