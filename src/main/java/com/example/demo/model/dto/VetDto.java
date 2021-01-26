package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class VetDto {

    String firstName;
    String lastName;
    List<String> Specialties=new ArrayList<>();

    @Builder
    public VetDto(String firstName,String lastName,List<String> Specialties){
    this.firstName=firstName;
    this.lastName=lastName;
    this.Specialties=Specialties;
    }
}
