package com.example.demo.Component;

import com.example.demo.model.PetType;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class PetTypeFormatter implements Formatter<PetType> {
    private final PetRepository pets;
}
