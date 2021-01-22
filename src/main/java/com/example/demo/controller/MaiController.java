package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MaiController {

	@GetMapping("/owners/find")
	public String FindOwnerPage(Map<String, Object> model) {
		return "owners/findOwners";
	}

	@GetMapping("/veterinarians")
	public String ViewVeterinarians(Map<String, Object> model) {
		return "vets/vetList";
	}

}
