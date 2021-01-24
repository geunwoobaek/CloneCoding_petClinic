 package com.example.demo.repository.custom;

 import com.example.demo.model.Owner;
 import com.example.demo.model.QOwner;
 import com.example.demo.model.QPet;
 import com.example.demo.model.dto.OwnerDto;
 import com.example.demo.model.dto.QOwnerDto;
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


 Map<Owner, List<String>> transform = query
 .from(QOwner.owner)
 .leftJoin(QOwner.owner.pets, QPet.pet)
 .transform(groupBy(QOwner.owner).as(list(QPet.pet.name)));

 return transform.entrySet().stream()
 .map(entry -> new OwnerDto(entry.getKey().getFirstName(),
 entry.getKey().getLastName(),
 entry.getValue()))
 .collect(Collectors.toList());
 }
 }
