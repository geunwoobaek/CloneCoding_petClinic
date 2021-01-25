package com.example.demo.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class VetDto {
    String name;
    List<String> Specialties=new ArrayList<>();
    public VetDto(String name,List<String> Specialties){
    this.name=name;
    this.Specialties=Specialties;
    }
}
