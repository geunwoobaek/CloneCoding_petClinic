package com.example.demo.api;

import com.example.demo.model.dto.OwnerDto;
import com.example.demo.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OwnerApiController {
    private final OwnerService ownerService;
    @GetMapping("/api/owner")
    public List<OwnerDto> showOfOwner(){
    return ownerService.getOwnerList();
    }
    @PostMapping("/api/owner")
    public List<OwnerDto> AddOwner(){
    return null;
    }
    @PutMapping("/api/owner")
    public List<OwnerDto> EditOwner(){
        return null;
    }

}
