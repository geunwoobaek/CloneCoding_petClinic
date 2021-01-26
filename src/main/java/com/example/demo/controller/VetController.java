package com.example.demo.controller;

import com.example.demo.service.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class VetController {

	private final VetService vetService;
	@GetMapping("/veterinarians")
	public String ViewVeterinarians(Map<String, Object> model) {
		model.put("vets", vetService);
		return "vets/vetList";
	}

}
