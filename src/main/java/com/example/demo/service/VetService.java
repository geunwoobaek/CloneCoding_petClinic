package com.example.demo.service;

import com.example.demo.converter.VetConverter;
import com.example.demo.model.Vet;
import com.example.demo.model.dto.VetDto;
import com.example.demo.repository.vet.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VetService {
    private final VetRepository vetRepository;
    private final VetConverter vetConverter;

    public List<VetDto> getVetListUsingBatch() {
        return vetConverter.ConvertToDtos(vetRepository.findAll());
    }
    public List<VetDto> getVetListUsingJoinFetch() {
        return vetConverter.ConvertToDtos(vetRepository.findVetListByJoinFetch());
    }
    public void save(Vet vet) {
        vetRepository.save(vet);
    }
    public void PrintAll() {
        System.out.println(getVetListUsingJoinFetch());
    }

}
