package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource("classpath:application.yml")
public class OwnerServiceTest {
    @SpyBean
    OwnerService ownerService;

    @Test
    @DisplayName("주인 테스트")
    void OwnerTest(){
        Owner owner1,owner2;
        Pet pet1,pet2,pet3;

    }
}
