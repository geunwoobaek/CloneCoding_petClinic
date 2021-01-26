package com.example.demo.mockservice;

import com.example.demo.model.Specialty;
import com.example.demo.model.Vet;
import com.example.demo.model.VetSpecialty;
import com.example.demo.service.SpecialtyService;
import com.example.demo.service.VetService;
import com.example.demo.service.VetSpecialityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource("classpath:application.yml")
@ExtendWith(MockitoExtension.class)
class MockVetService {
    @SpyBean
    VetSpecialityService vetSpecialityService;
    @SpyBean
    VetService vetService;
    @SpyBean
    SpecialtyService specialtyService;
//    @MockBean
//    VetSpecialtyRepository vetSpecialtyRepository;
//    @MockBean
//    SpecialtyRepository specialtyRepository;
//    @MockBean
//    VetRepository vetRepository;

    @BeforeEach
    @DisplayName("초기 데이터 입력")
    void init() {
      //  setUp();
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


        VetSpecialty vetSpecialty1=new VetSpecialty().builder().vet(vet1).specialty(specialty1).build();
        VetSpecialty vetSpecialty2=new VetSpecialty().builder().vet(vet1).specialty(specialty3).build();
        VetSpecialty vetSpecialty3=new VetSpecialty().builder().vet(vet2).specialty(specialty2).build();
        VetSpecialty vetSpecialty4=new VetSpecialty().builder().vet(vet2).specialty(specialty3).build();
        VetSpecialty vetSpecialty5=new VetSpecialty().builder().vet(vet3).specialty(specialty1).build();
        VetSpecialty vetSpecialty6=new VetSpecialty().builder().vet(vet3).specialty(specialty2).build();

        System.out.println(vetSpecialityService.addOne(vetSpecialty1));
        System.out.println(vetSpecialityService.addOne(vetSpecialty2));
        System.out.println(vetSpecialityService.addOne(vetSpecialty3));
        System.out.println(vetSpecialityService.addOne(vetSpecialty4));
        System.out.println(vetSpecialityService.addOne(vetSpecialty5));
        System.out.println(vetSpecialityService.addOne(vetSpecialty6));

    }

    @DisplayName("Vet ->VetDto 테스트")
    @Test
    void PrintTest() {
       System.out.println("Start");
        vetSpecialityService.PrintAll();
        vetService.PrintAll();
       specialtyService.PrintAll();
    }
//    void setUp(){
//        vetSpecialityService=new VetSpecialityService(vetSpecialtyRepository);
//        vetService=new VetService(vetRepository);
//        specialtyService=new SpecialtyService(specialtyRepository);
//    }
}