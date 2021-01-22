package com.example.demo.repository;

import com.example.demo.model.Owner;
import com.example.demo.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

}