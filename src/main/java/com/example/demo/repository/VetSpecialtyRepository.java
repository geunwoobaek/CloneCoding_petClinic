package com.example.demo.repository;

import com.example.demo.model.Owner;
import com.example.demo.model.VetSpecialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetSpecialtyRepository extends JpaRepository<VetSpecialty,Long> {

}
