package com.fbmania.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fbmania.model.Category;
import com.fbmania.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	public List<Category> getAllCategorys() {
		return repo.findAll();
	}

	public Category getCategoryById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Category not found with id: " + id));
	}
	
	public Category getCategoriesByName(String name) throws Exception {
		return repo.getByCategoryName(name).orElseThrow(
				() -> new Exception("No products found with category: " + name));
	}

	public ResponseEntity<String> addCategory(Category category) {
		repo.save(category);
		return ResponseEntity.status(HttpStatus.OK).body("Category added successfully.");
	}

	public ResponseEntity<String> updateCategory(Category category) {
		if(repo.findById(category.getCategoryId()).isPresent()) {
			repo.save(category);
			return ResponseEntity.status(HttpStatus.OK)
				.body("Category updated successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while updating category.");
	}
	
	public ResponseEntity<String> deleteCategory(Long id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK)
				.body("Category deleted successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("An error occurred while trying to remove category.");
	}
}
