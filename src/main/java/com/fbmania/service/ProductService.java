package com.fbmania.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fbmania.model.Product;
import com.fbmania.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getProductById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Product not found with id: " + id));
	}
	
	public List<Product> getProductsByRange(BigDecimal min, BigDecimal max) throws Exception {
		return repo.getProductsByRange(min, max).orElseThrow(
				() -> new Exception("No products found with price range: $"
						+ min + " - $" + max));
	}

	public ResponseEntity<String> addProduct(Product product) {
		repo.save(product);
		return ResponseEntity.status(HttpStatus.OK).body("Product added successfully.");
	}

	public ResponseEntity<String> updateProduct(Product product) {
		if (repo.findById(product.getProductId()).isPresent()) {
			repo.save(product);
			return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An error occurred while updating product.");
	}

	public ResponseEntity<String> deleteProduct(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An error occurred while trying to remove product.");
	}

}
