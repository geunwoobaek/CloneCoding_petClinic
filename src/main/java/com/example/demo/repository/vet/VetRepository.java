package com.example.demo.repository.vet;

import com.example.demo.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long>,VetRepositoryCustom {

}
