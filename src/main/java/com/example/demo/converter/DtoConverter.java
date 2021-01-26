package com.example.demo.converter;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class DtoConverter<T, T2> {

	public abstract T2 ConvertToDto(T Domain);

	public List<T2> ConvertToDtos(List<T> Domains) {
		return (List<T2>) Domains.stream().map(Domain -> ConvertToDto(Domain)).collect(Collectors.toList());
	}

}
