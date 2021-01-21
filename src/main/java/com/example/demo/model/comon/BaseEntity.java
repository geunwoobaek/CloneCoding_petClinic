package com.example.demo.model.comon;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@MappedSuperclass
@Data
public class BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
}
