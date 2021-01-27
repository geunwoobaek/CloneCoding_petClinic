package com.example.demo.api;

import com.example.demo.model.Owner;
import com.example.demo.model.dto.OwnerDto;
import com.example.demo.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OwnerApiController {

	private final OwnerService ownerService;

	@GetMapping("/api/owner")
	public List<OwnerDto> showOfOwner() {
		System.out.println(ownerService.getOwnerList().toString());
		return ownerService.getOwnerList();
	}

	@PostMapping("/api/owner")
	public OwnerDto AddOwner(@RequestBody @Valid OwnerDto owner) {
		System.out.println(owner);
		return ownerService.Join(owner);
	}

	@PutMapping("/api/owner")
	public List<OwnerDto> EditOwner(@RequestBody @Valid Owner owner) {
		return null;
	}

}
