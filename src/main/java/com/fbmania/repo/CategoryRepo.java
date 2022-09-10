package com.fbmania.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.fbmania.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

	@Query("SELECT c FROM Category c WHERE c.category = :category")
	public Optional<Category> getByCategoryName(@PathVariable String category);
}
