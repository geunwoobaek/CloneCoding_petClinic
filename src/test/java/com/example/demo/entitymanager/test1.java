package com.example.demo.entitymanager;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.service.OwnerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@DisplayName("전체 도메인 테스트")
public class test1 {

	Owner owner;

	@PersistenceContext
	EntityManager em;

	@Autowired
	OwnerService ownerService;

	@Test
	@Transactional
	@DisplayName("엔티티매니저 테스트")
	void EntityTest() {
		owner = new Owner();
		Pet pet = new Pet();
		pet.setName("geunwoo");
		owner.setFullName("g", "f");
		owner.AddPet(pet);
		em.persist(owner);
		System.out.println(em.getReference(Pet.class, pet.getId()));
		System.out.println(em.getReference(Owner.class, owner.getId()));
		assert ownerService.findOneById(owner.getId()).getPets().size() == 1;
	}

	@Test
	@Transactional
	@DisplayName("엔티티 매니저 테스트2")
	void Command() {
		assert ownerService.findOneById(owner.getId()).getPets().size() == 1;
	}

}
