package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.repository.owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerService {

	private final OwnerRepository ownerRepository;

    public Owner findOneById(Long ownerId) {
        return ownerRepository.findOwnerById(ownerId);
    }

}
