package com.fbmania.repo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.fbmania.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
	public Optional<List<Product>> getProductsByRange(@PathVariable BigDecimal min,
				@PathVariable BigDecimal max);
}
