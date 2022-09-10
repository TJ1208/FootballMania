package com.fbmania.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fbmania.model.Address;
import com.fbmania.repo.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo repo;
	
	public List<Address> getAllAddresss() {
		return repo.findAll();
	}

	public Address getAddressById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Address not found with id: " + id));
	}

	public ResponseEntity<String> addAddress(Address address) {
		repo.save(address);
		return ResponseEntity.status(HttpStatus.OK).body("Address added successfully.");
	}

	public ResponseEntity<String> updateAddress(Address address) {
		if(repo.findById(address.getAddressId()).isPresent()) {
			repo.save(address);
			return ResponseEntity.status(HttpStatus.OK)
				.body("Address updated successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while updating address.");
	}
	
	public ResponseEntity<String> deleteAddress(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
				.body("Address deleted successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while trying to remove address.");
	}

}
