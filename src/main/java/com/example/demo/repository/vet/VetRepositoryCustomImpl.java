package com.example.demo.repository.vet;

import com.example.demo.model.QVet;
import com.example.demo.model.QVetSpecialty;
import com.example.demo.model.Vet;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.types.Projections.list;

@Repository
@RequiredArgsConstructor
public class VetRepositoryCustomImpl implements VetRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public List findVetListByJoinFetch() {
		QVet vet = QVet.vet;
		QVetSpecialty vetSpecialty = QVetSpecialty.vetSpecialty;

		Map<Vet, List<?>> result = query.from(vet).leftJoin(vet.vetSpecialtyList,vetSpecialty).
				transform(groupBy(vet).as(list(vetSpecialty.specialty.name)));
		return result.entrySet().stream().collect(Collectors.toList());
	}


}
