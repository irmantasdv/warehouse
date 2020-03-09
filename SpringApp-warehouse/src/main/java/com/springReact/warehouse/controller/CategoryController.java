package com.springReact.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springReact.warehouse.model.Category;
import com.springReact.warehouse.model.ProductModel;
import com.springReact.warehouse.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping(path = "/categories")
	public List<Category> returnAllCategories() {

		return categoryService.getAllCategories();
	}

	@GetMapping(path = "/categories/{id}/products")
	public ResponseEntity<Category> returnCategoryProducts(@PathVariable Long id) {

		return categoryService.getCategoryproducts(id);
	}

//	@PutMapping("/categories/{id}/products")
//	public ResponseEntity<Category> updateProductModel(@RequestParam Long id, @RequestBody ProductModel product) {
//		return categoryService.addProductToCategory(id, product);
//	}
	@PostMapping("/categories/category")
	public ResponseEntity<Category> postCategory(Category category) {
		return categoryService.createCategory(category);
	}

	@PutMapping("/categories/category/{id}")
	public ResponseEntity<Category> createProductInCategory(@PathVariable Long id,@RequestBody Category category) {

		return categoryService.updateCategory(id, category);
	}
}
