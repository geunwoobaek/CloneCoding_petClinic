package com.example.demo.service;

import com.example.demo.converter.VetConverter;
import com.example.demo.model.Vet;
import com.example.demo.model.dto.VetDto;
import com.example.demo.repository.vet.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@XmlRootElement
public class VetService {

	private final VetRepository vetRepository;

	private final VetConverter vetConverter;
	@XmlElement
	public List<VetDto> getVetList() {
		return vetConverter.ConvertToDtos(vetRepository.findAll());
	}

	public void save(Vet vet) {
		vetRepository.save(vet);
	}

	public void PrintAll() {
		getVetList().stream().forEach(vet->
				System.out.println(
						"의사: "+vet.getFirstName()+vet.getLastName()+", 전문의는 "+vet.getSpecialties().toString()));
	}

}
