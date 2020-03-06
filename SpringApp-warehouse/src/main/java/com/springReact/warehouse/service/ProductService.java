package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.springReact.warehouse.product.ProductModel;

public interface ProductService {

	List<ProductModel> getProducts();

	ResponseEntity<ProductModel> getProductById(Long id);

	ResponseEntity<?> deleteProduct(Long id);

	ResponseEntity<ProductModel> createProduct(ProductModel product);

	ResponseEntity<ProductModel> updateProduct(Long id, ProductModel product);

}
