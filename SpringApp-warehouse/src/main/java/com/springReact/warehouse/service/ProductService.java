package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springReact.warehouse.product.ProductModel;

public interface ProductService {

	List<ProductModel> getProducts();
	
	ResponseEntity<ProductModel> getProductById(Long id);

}
