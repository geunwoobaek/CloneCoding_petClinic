package com.example.demo.repository.custom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OwnerRepositoryCustomImpl implements OwnerRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public List findAllPeyByOwner() {
//        List result = query
//                .select(owner.firstName, owner.lastName, owner.pets.any().name)
//                .from(owner)
//                .innerJoin(owner.pets)
//                .fetchJoin()
//                .fetch();
//        return result;
        return null;
    }
}
