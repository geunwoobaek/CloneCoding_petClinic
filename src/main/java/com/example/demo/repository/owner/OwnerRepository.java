package com.example.demo.repository.owner;

import com.example.demo.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>, OwnerRepositoryCustom {
	Owner findOwnerById(Long id);
	Owner findOwnerByLastName(String name);

}
