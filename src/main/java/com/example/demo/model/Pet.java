package com.example.demo.model;

import com.example.demo.model.comon.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pet extends BaseEntity {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;
    @OneToMany
    @JoinColumn(name="visit_id")
    List<Visit> visits;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id")
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="onwer_id")
    private Owner owner;

    //연관관계매핑
    public void setType(Type type){
        this.type=type;
        type.getPets().add(this);
    }

}
