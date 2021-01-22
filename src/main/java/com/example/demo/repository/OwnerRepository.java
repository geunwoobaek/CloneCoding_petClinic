package com.example.demo.repository;

import com.example.demo.model.Owner;
import com.example.demo.repository.custom.OwnerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> , OwnerRepositoryCustom {
Owner findOwnerByLastName(String name);
}
