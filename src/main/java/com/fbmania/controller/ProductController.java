package com.fbmania.controller;

import java.math.BigDecimal;
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

import com.fbmania.model.Product;
import com.fbmania.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping()
	public List<Product> getAllProduct() {
		return service.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) 
			throws Exception {
		return service.getProductById(id);
	}
	
	@GetMapping("/range/{min},{max}")
	public List<Product> getProductByName(@PathVariable BigDecimal min, @PathVariable BigDecimal max) 
			throws Exception {
		return service.getProductsByRange(min, max);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		return service.deleteProduct(id);
	}

}
