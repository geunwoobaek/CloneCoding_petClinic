package com.example.demo.service;

import com.example.demo.model.Pet;
import com.example.demo.model.Type;
import com.example.demo.repository.PetRepository;
import com.example.demo.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {

	private final PetRepository petRepository;

	private final TypeRepository typeRepository;

	public Pet addPet(Pet pet) {
		return petRepository.save(pet);
	}

	public Pet findPetById(Long id) {
		return petRepository.findPetById(id);
	}

	public List<Type> findPetTypes() {
		return typeRepository.findAll();
	}

}
