package com.example.demo.api;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.model.Type;
import com.example.demo.service.OwnerService;
import com.example.demo.service.PetService;
import com.example.demo.validator.PetValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/owenrs/{ownersId}")
@RequiredArgsConstructor
public class PetController {
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService petService;
    private final OwnerService ownerService;

    @ModelAttribute("types")
    public Collection<Type> populatePetTypes() {
        return this.petService.findPetTypes();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.findOneById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("pet")
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new PetValidator());
    }
    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, ModelMap model){
        Pet pet=new Pet();
        owner.AddPet(pet);
        model.put("pet",pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }
    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable("PetId") Long petId,ModelMap model){
        Pet pet=this.petService.findPetById(petId);
        model.put("pet",pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }
    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result,Owner owner,ModelMap model){
        if(result.hasErrors()){
            pet.setOwner(owner);
            model.put("pet",pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }
        else {
            owner.AddPet(pet);
            this.petService.addPet(pet);
            return "redirect:/owners/{ownerId}";
        }
    }

}
