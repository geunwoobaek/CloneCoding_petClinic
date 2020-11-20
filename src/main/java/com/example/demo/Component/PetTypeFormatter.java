package com.example.demo.Component;

import com.example.demo.Repository.PetRepository;
import com.example.demo.model.PetType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component

public class PetTypeFormatter implements Formatter<PetType> {

    private final PetRepository pets;

    @Autowired
    public PetTypeFormatter(PetRepository pets) {
        this.pets = pets;
    }
    
    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = this.pets.findPetTypes();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
