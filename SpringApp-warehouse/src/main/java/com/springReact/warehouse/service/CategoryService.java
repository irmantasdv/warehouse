package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springReact.warehouse.model.Category;
import com.springReact.warehouse.model.ProductModel;

public interface CategoryService {

	List<Category> getAllCategories();

	ResponseEntity<Category> getCategoryproducts(Long id);

	ResponseEntity<Category> addProductToCategory(Long id, ProductModel product);

	ResponseEntity<Category> createCategory(Category category);
	
	ResponseEntity<Category> updateCategory(Long id, Category category);

}
