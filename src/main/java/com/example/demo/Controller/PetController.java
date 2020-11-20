package com.example.demo.Controller;

import com.example.demo.Repository.OwnerRepository;
import com.example.demo.Repository.PetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetRepository pets;
    private final OwnerRepository owners;

    public PetController(PetRepository pets,OwnerRepository owners){
        this.pets=pets;
        this.owners=owners;
    }
    @ModelAttribute("types")



}
