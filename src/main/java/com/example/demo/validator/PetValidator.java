package com.example.demo.validator;


import com.example.demo.model.Pet;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PetValidator implements Validator {
    private static final String REQUIRED = "required";

    @Override
    public boolean supports(Class<?> aClass) {
        return Pet.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Pet pet = (Pet) obj;
        String name = pet.getName();
        //name validator
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name",REQUIRED,REQUIRED);
        }
        //type validation
        if (pet.isNew()&&pet.getType()==null) {
            errors.rejectValue("type",REQUIRED,REQUIRED);
        }
        //birth date validation
        if (pet.getBirthDate()==null) {
            errors.rejectValue("name",REQUIRED,REQUIRED);
        }
    }
}
