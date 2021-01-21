package com.example.demo.repository;

import com.example.demo.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet,Long> {
}
