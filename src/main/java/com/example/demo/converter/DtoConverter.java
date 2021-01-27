package com.example.demo.converter;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class DtoConverter<T, T2> {

	public abstract T2 DomainToDto(T Domain);
	public abstract T DtoToDomain(T2 Dto);
	public List<T2> ConvertToDtos(List<T> Domains) {
		return (List<T2>) Domains.stream().map(Domain -> DomainToDto(Domain)).collect(Collectors.toList());
	}

}
