package com.example.demo.repository.owner;

import java.util.List;

public interface OwnerRepositoryCustom {

	List findAllPetByOwner();

	List findAllOwnerByFetchJoin();

}
