package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@RequiredArgsConstructor
public class DomainTest {
    Pet pet1, pet2;
    Owner owner;
    Type type1, type2;
    Vet vet;
    final PetRepository petRepository;
    final OwnerRepository ownerRepository;
    final SpecialtyRepository specialtyRepository;
    final TypeRepository typeRepository;
    final VetSpecialtyRepository vetSpecialtyRepository;
    final VisitRepository visitRepository;
    final VetRepository vetRepository;

    @BeforeAll
    void initTest() {

        pet1 = new Pet();
        pet2 = new Pet();
        owner = new Owner();
        type1 = new Type();
        type2 = new Type();
        vet = new Vet();

        pet1.setName("jini");
        LocalDate birthDate = LocalDate.of(2019, 1, 2);
        pet1.setBirthDate(birthDate);

        pet2.setName("jini");
        LocalDate birthDate2 = LocalDate.of(2018, 4, 12);
        pet2.setBirthDate(birthDate);

        type1.setName("Pet");
        type2.setName("Cat");

        pet1.setType(type1);
        pet1.setType(type2);

}

    @Test
    @DisplayName("팻 데이터 테스트")
    void PetTest() {
    }
}
