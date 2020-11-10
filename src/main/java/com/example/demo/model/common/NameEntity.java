package com.example.demo.model.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class NameEntity extends BaseEntity{

    @Column(name="name")
    private String name;

    @Override
    public String toString(){
        return this.getName();
    }


}
