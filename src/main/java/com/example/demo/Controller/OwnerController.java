package com.example.demo.Controller;


import com.example.demo.Repository.OwnerRepository;
import com.example.demo.Repository.VisitRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;

@Getter
@Setter
@Controller
class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM="owners/createOrUpdateOwnerForm";
    private OwnerRepository owners;
    private VisitRepository visits;
    public OwnerController(OwnerRepository clinicService, VisitRepository visits) {
        this.owners = clinicService;
        this.visits = visits;
    }
    
}
