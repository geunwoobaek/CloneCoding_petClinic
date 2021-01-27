package com.example.demo;

import com.example.demo.model.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Component
@Transactional
public class InitDataInsert  implements
		ApplicationListener<ContextRefreshedEvent> {

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("초기화 시작...");
		Pet pet1, pet2, pet3, pet4, pet5, pet6;
		Owner owner1, owner2, owner3, owner4;
		pet1 = new Pet().builder().name("pet1").birthDate(LocalDate.of(2019, 1, 2))
				.type((new Type().builder().name("Cat").build())).build();
		pet2 = new Pet().builder().name("pet2").birthDate(LocalDate.of(2018, 2, 10))
				.type((new Type().builder().name("Dog").build())).build();
		pet3 = new Pet().builder().name("pet3").birthDate(LocalDate.of(2015, 12, 10))
				.type((new Type().builder().name("Bird").build())).build();
		pet4 = new Pet().builder().name("pet4").birthDate(LocalDate.of(2009, 11, 2))
				.type((new Type().builder().name("Lion").build())).build();
		pet5 = new Pet().builder().name("pet5").birthDate(LocalDate.of(2018, 4, 13))
				.type((new Type().builder().name("Tiger").build())).build();
		pet6 = new Pet().builder().name("pet6").birthDate(LocalDate.of(2013, 5, 10))
				.type((new Type().builder().name("Shark").build())).build();
		owner1 = new Owner();
		owner1.setFullName("geunwoo", "Baek");
		owner2 = new Owner();
		owner2.setFullName("JACK", "BOB");
		owner3 = new Owner();
		owner3.setFullName("Richard", "heck");
		owner4 = new Owner();
		owner4.setFullName("gey", "hei");

		owner1.AddPet(pet1);
		owner1.AddPet(pet2);
		owner2.AddPet(pet3);
		owner2.AddPet(pet4);
		owner3.AddPet(pet5);
		owner4.AddPet(pet6);

		Vet vet1 = new Vet();
		vet1.setFullName("Harry", "Kane");
		Vet vet2 = new Vet();
		vet2.setFullName("Heungmin", "Son");
		Vet vet3 = new Vet();
		vet3.setFullName("Jack", "Gllish");
		Vet vet4 = new Vet();
		vet3.setFullName("Harry", "winks");
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

		em.persist(owner1);
		em.persist(owner2);
		em.persist(owner3);
		em.persist(owner4);
		em.persist(vetSpecialty1);
		em.persist(vetSpecialty2);
		em.persist(vetSpecialty3);
		em.persist(vetSpecialty4);
		em.persist(vetSpecialty5);
		em.persist(vetSpecialty6);
		System.out.println("초기화 완성");
	}

}
