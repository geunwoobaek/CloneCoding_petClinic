package com.example.demo.Controller;

import com.example.demo.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    OwnerRepository ownerrepos;

    @RequestMapping("/say")
    public void sayhi(){
    }
}
