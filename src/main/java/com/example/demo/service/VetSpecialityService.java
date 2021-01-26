package com.example.demo.service;

import com.example.demo.model.VetSpecialty;
import com.example.demo.repository.VetSpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class VetSpecialityService {

	private final VetSpecialtyRepository vetSpecialtyRepository;

	public VetSpecialty addOne(VetSpecialty vetSpecialty) {
		return vetSpecialtyRepository.save(vetSpecialty);
	}

	public void PrintAll() {
		System.out.print("vetSpecialty:");
		System.out.println("size=" + vetSpecialtyRepository.findAll().size());
		vetSpecialtyRepository.findAll().stream().forEach(node -> System.out
				.println("의사이름은:" + node.getVet().getFirstName() + " , 전문의는 =" + node.getSpecialty().getName()));
		System.out.println();
	}

}
