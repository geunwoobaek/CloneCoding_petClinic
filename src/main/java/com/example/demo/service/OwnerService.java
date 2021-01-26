package com.example.demo.service;

import com.example.demo.converter.OwnerConverter;
import com.example.demo.model.Owner;
import com.example.demo.model.dto.OwnerDto;
import com.example.demo.repository.owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerService {

	private final OwnerRepository ownerRepository;
	public Owner Join(Owner owner){
		return ownerRepository.save(owner);
	}
	private final OwnerConverter ownerConverter;
	@Transactional(readOnly = true)
	public Owner findOneById(Long ownerId) {
		return ownerRepository.findOwnerById(ownerId);
	}
	public List<OwnerDto> getOwnerList(){
		List Owners=ownerRepository.findAllOwnerByFetchJoin();
		List result=ownerConverter.ConvertToDtos(Owners);
		return result;
	}
}
