package com.example.demo.repository.owner;

import com.example.demo.model.Owner;
import com.example.demo.model.QOwner;
import com.example.demo.model.QPet;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@Repository
@RequiredArgsConstructor
public class OwnerRepositoryCustomImpl implements OwnerRepositoryCustom {

	private final JPAQueryFactory query;

	@Override
	public List findAllPetByOwner() {

		Map<Owner, List<String>> transform = query.from(QOwner.owner).leftJoin(QOwner.owner.pets, QPet.pet)
				.transform(groupBy(QOwner.owner).as(list(QPet.pet.name)));

		return transform.entrySet().stream().collect(Collectors.toList());
	}

	@Override
	public List findAllOwnerByFetchJoin() {
		return query.selectDistinct(QOwner.owner).
				from(QOwner.owner).
				innerJoin(QOwner.owner.pets, QPet.pet).
				fetchJoin().
				fetch();
	}

}
