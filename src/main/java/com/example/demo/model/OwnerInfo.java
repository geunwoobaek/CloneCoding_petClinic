package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class OwnerInfo {

	String address;

	String city;

	String telephone;

}
