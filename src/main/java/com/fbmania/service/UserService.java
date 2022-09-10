package com.fbmania.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fbmania.model.User;
import com.fbmania.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	public List<User> getAllUsers() {
		return repo.findAll();
	}

	public User getUserById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("User not found with id: " + id));
	}

	public List<User> getUsersByName(String name) throws Exception {
		return repo.getUsersByName(name).orElseThrow(() -> new Exception("No users not found with username: " + name));
	}

	public ResponseEntity<String> addUser(User user) {
		repo.save(user);
		return ResponseEntity.status(HttpStatus.OK).body("Welcome " + user.getFirstname() + "!");
	}

	public ResponseEntity<String> updateUser(User user) {
		if(repo.findById(user.getUserId()).isPresent()) {
			repo.save(user);
			return ResponseEntity.status(HttpStatus.OK)
				.body("User details updated.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while updating details.");
	}
	
	public ResponseEntity<String> deleteUser(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
				.body("User account deleted.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while trying to delete account.");
	}
}
