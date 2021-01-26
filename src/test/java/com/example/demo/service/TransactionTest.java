package com.example.demo.service;

import com.example.demo.model.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource("classpath:application.yml")
public class TransactionTest {

	@Autowired
	PetService petService;

	@Test
	@DisplayName("영속성 컨텍스트 호출 및 공유 테스트")
	@Rollback
	void TransactionalTest() {
		// given
		Pet pet = new Pet();
		Pet temp2;
		pet.setName("Jack");
		pet = petService.addPet(pet);
		// when
		temp2 = petService.findPetById(pet.getId());
		// then
		assert pet != temp2;
	}

}
