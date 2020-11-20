package com.example.demo.model;

import com.example.demo.model.common.NameEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="types")
public class PetType extends NameEntity {
}
