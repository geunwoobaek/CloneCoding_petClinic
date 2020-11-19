package com.example.demo.Repository;

import com.example.demo.model.Pet;
import com.example.demo.model.PetType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@org.springframework.stereotype.Repository
public interface PetRepository extends Repository<Pet, Integer> {

    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
    @Transactional(readOnly=true)
    List<PetType> findPetTypes();
    @Transactional(readOnly = true)
    Pet findById(Integer id);

    void save(Pet pet);

}
