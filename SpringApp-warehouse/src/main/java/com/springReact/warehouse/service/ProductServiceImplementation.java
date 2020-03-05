package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springReact.warehouse.ProductRepository.ProductRepository;
import com.springReact.warehouse.product.ProductModel;

@CrossOrigin
@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductModel> getProducts() {

		return productRepository.findAll();
	}

	@Override
	public ResponseEntity<ProductModel> getProductById(Long id) {
		return productRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

}
