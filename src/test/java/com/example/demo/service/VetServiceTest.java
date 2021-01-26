package com.example.demo.service;

import com.example.demo.model.Specialty;
import com.example.demo.model.Vet;
import com.example.demo.model.VetSpecialty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application.yml")
class VetServiceTest {

	@Autowired
	VetSpecialityService vetSpecialityService;

	@Autowired
	VetService vetService;

	@Autowired
	SpecialtyService specialtyService;

	@BeforeEach
	@DisplayName("초기 데이터 입력")
	void init() {
		Vet vet1 = new Vet();
		vet1.setFullName("Harry", "Kane");
		Vet vet2 = new Vet();
		vet2.setFullName("Heungmin", "Son");
		Vet vet3 = new Vet();
		vet3.setFullName("Jack", "Gllish");
		Specialty specialty1 = new Specialty();
		specialty1.setName("Surgery1");
		Specialty specialty2 = new Specialty();
		specialty2.setName("Surgery2");
		Specialty specialty3 = new Specialty();
		specialty3.setName("Surgery3");

		VetSpecialty vetSpecialty1 = new VetSpecialty().builder().vet(vet1).specialty(specialty1).build();
		VetSpecialty vetSpecialty2 = new VetSpecialty().builder().vet(vet1).specialty(specialty3).build();
		VetSpecialty vetSpecialty3 = new VetSpecialty().builder().vet(vet2).specialty(specialty2).build();
		VetSpecialty vetSpecialty4 = new VetSpecialty().builder().vet(vet2).specialty(specialty3).build();
		VetSpecialty vetSpecialty5 = new VetSpecialty().builder().vet(vet3).specialty(specialty1).build();
		VetSpecialty vetSpecialty6 = new VetSpecialty().builder().vet(vet3).specialty(specialty2).build();

		System.out.println("1."+vetSpecialityService.addOne(vetSpecialty1));
		System.out.println("2."+vetSpecialityService.addOne(vetSpecialty2));
		System.out.println("3."+vetSpecialityService.addOne(vetSpecialty3));
		System.out.println("4."+vetSpecialityService.addOne(vetSpecialty4));
		System.out.println("5."+vetSpecialityService.addOne(vetSpecialty5));
		System.out.println("6."+vetSpecialityService.addOne(vetSpecialty6));

	}

	@DisplayName("Vet ->VetDto 테스트")
	@Test
	void vetSpecialityServiceTest() {
		System.out.println("1Start");
//		vetSpecialityService.PrintAll();
		vetService.PrintAll();
	//	specialtyService.PrintAll();
	}

}