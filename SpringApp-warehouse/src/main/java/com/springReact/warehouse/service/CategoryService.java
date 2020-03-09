package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springReact.warehouse.model.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	ResponseEntity<Category> getCategoryproducts(Long id);

	ResponseEntity<Category> createCategory(Category category);

	ResponseEntity<Category> updateCategory(Long id, Category category);

	ResponseEntity<?> deleteCategory(Long id);

}
