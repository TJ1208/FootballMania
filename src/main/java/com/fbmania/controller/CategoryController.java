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

import com.fbmania.model.Category;
import com.fbmania.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping()
	public List<Category> getAllCategory() {
		return service.getAllCategorys();
	}
	
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable Long id) 
			throws Exception {
		return service.getCategoryById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addCategory(@RequestBody Category category) {
		return service.addCategory(category);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCategory(@RequestBody Category category) {
		return service.updateCategory(category);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		return service.deleteCategory(id);
	}
}
