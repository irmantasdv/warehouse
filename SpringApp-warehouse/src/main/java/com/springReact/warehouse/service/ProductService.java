package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springReact.warehouse.model.ProductModel;

public interface ProductService {

	List<ProductModel> getProducts();

	ResponseEntity<ProductModel> getProductById(Long id);

	ResponseEntity<?> deleteProduct(Long id);

	ResponseEntity<ProductModel> createProduct(ProductModel product);

	ResponseEntity<ProductModel> updateProduct(Long id, ProductModel product);

}
