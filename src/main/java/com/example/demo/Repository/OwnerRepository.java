package com.example.demo.Repository;


import com.example.demo.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    @Transactional(readOnly = true)
    Collection<Owner> findByLastName(String lastName);

    @Transactional(readOnly = true)
    Optional<Owner> findById(Integer id);
}
