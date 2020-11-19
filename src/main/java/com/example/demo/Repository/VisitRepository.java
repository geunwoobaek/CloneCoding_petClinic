package com.example.demo.Repository;

import com.example.demo.model.Visit;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;


import java.util.List;

@org.springframework.stereotype.Repository
public interface VisitRepository extends Repository<Visit, Integer> {

    void save(Visit visit) throws DataAccessException;

    List<Visit> findByPetId(Integer petId);

}

