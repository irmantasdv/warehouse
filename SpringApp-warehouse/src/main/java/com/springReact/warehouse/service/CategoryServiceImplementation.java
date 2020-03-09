package com.springReact.warehouse.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springReact.warehouse.model.Category;
import com.springReact.warehouse.model.ProductModel;
import com.springReact.warehouse.repository.CategoryRepository;
import com.springReact.warehouse.repository.ProductRepository;

@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryRepository cetegoryRepository;

	@Override
	public List<Category> getAllCategories() {

		return cetegoryRepository.findAll();
	}

	@Override
	public ResponseEntity<Category> getCategoryproducts(Long id) {

		return cetegoryRepository.findById(id).map(record -> {
			record.getProducts();
			return ResponseEntity.ok().body(record);

		}).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Category> addProductToCategory(Long id, ProductModel product) {

		return cetegoryRepository.findById(id).map(record -> {
			record.getProducts().add(product);
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Category> createCategory(Category category) {
		cetegoryRepository.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).body(category);
	}

	@Override
	public ResponseEntity<Category> updateCategory(Long id, Category category) {

		return cetegoryRepository.findById(id).map(record -> {
			record.setName(category.getName());
			record.setDecription(category.getDecription());
			Category updated = cetegoryRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

}
