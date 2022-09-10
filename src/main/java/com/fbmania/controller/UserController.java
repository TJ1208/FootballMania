package com.fbmania.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fbmania.model.User;
import com.fbmania.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping()
	public List<User> getAllUser() {
		return service.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) 
			throws Exception {
		return service.getUserById(id);
	}
	
	@GetMapping("/name/{username}")
	public List<User> getUsersByName(@PathVariable String username) 
			throws Exception {
		return service.getUsersByName(username);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return service.addUser(user);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return service.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}

}
