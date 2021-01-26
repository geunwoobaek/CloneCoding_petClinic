package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.model.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource("classpath:application.yml")
public class OwnerServiceTest {
    @SpyBean
    OwnerService ownerService;
    Pet pet1, pet2,pet3;
    Owner owner1,owner2;

    @BeforeEach
    @DisplayName("초기화 owner 두개, pet3개 생성")
    void Init() {
        //given
        pet1 = new Pet().builder().
                name("pet1").birthDate(LocalDate.of(2019, 1, 2)).build();
        pet2 = new Pet().builder().
                name("pet2").birthDate(LocalDate.of(2018, 2, 10)).build();
        pet3 = new Pet().builder().
                name("pet3").birthDate(LocalDate.of(2015, 12, 10)).build();
        pet1.setType(new Type().builder().name("Cat").build());
        pet2.setType(new Type().builder().name("Dog").build());
        pet3.setType(new Type().builder().name("Bird").build());
        owner1 = new Owner();
        owner1.setFirstName("geunwoo");
        owner1.setLastName("Baek");
        owner2 = new Owner();
        owner2.setFirstName("Jack");
        owner2.setLastName("BOB");

        owner1.AddPet(pet1);
        owner1.AddPet(pet2);
        owner2.AddPet(pet3);
        //when
        ownerService.Join(owner1);
        ownerService.Join(owner2);
    }
    @Test
    @DisplayName("지연로딩 실패 테스트")
    @Rollback
    void FailTest() {
        System.out.println("트랜잭션 1");
        System.out.println(ownerService.findOneById(owner1.getId()).getFirstName());
        System.out.println("트랜잭션 2");
        System.out.println(ownerService.findOneById(owner1.getId()).getPets());
    }
    @Test
    @DisplayName("ownerservice: 저장 테스트")
    @Rollback
    @Transactional
    void joinTest() {

        //then
        System.out.println("트랜잭션 1");
        assert ownerService.getOwnerList().size() == 2;
        System.out.println("트랜잭션 2");
        assert ownerService.findOneById(owner1.getId()).getPets().size()==2;
        System.out.println("트랜잭션 3");
        assert ownerService.findOneById(owner2.getId()).getPets().size()==1;
    }

    @Test
    @DisplayName("Dto 변환 테스트")
    void OwnerTest() {
        //then
        ownerService.getOwnerList().
                stream().
                forEach(ownerdto->System.out.println(ownerdto.toString()));
    }
}
