package com.example.demo.repository.vet;

import com.example.demo.model.Vet;

import java.util.List;

public interface VetRepositoryCustom {

	List<Vet> findVetListByJoinFetch();

}
