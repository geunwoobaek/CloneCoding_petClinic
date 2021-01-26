package com.example.demo.repository.vet;

import com.example.demo.model.QSpecialty;
import com.example.demo.model.QVet;
import com.example.demo.model.Vet;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VetRepositoryCustomImpl implements VetRepositoryCustom {
    private final JPAQueryFactory query;
    private QVet vet = QVet.vet;
    private QSpecialty specialty = QSpecialty.specialty;

    @Override
    public List<Vet> findVetListByJoinFetch() {
        return query.
                selectFrom(vet).
                innerJoin(specialty).
                fetchJoin().
                fetch();
    }
}
