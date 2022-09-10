package com.fbmania.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbmania.model.Address;
import com.fbmania.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping()
	public List<Address> getAllAddress() {
		return service.getAllAddresss();
	}
	
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable Long id) 
			throws Exception {
		return service.getAddressById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addAddress(@RequestBody Address address) {
		return service.addAddress(address);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
		return service.deleteAddress(id);
	}

}
