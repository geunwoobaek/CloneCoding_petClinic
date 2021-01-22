package com.example.demo.service;

import com.example.demo.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {

	private final OwnerRepository ownerRepository;

	// public Map<String, List> getOwnerPetMap(){
	//
	// }

}
