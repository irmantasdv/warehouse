package com.springReact.warehouse.service;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springReact.warehouse.repository.ProductRepository;
import com.springReact.warehouse.model.ProductModel;

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

	@Override
	public ResponseEntity<?> deleteProduct(Long id) {
		return productRepository.findById(id).map(record -> {
			productRepository.deleteById(id);
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<ProductModel> createProduct(ProductModel product) {
		productRepository.save(product);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
				.toUri();
		return ResponseEntity.created(uri).body(product);

	}

	@Override
	public ResponseEntity<ProductModel> updateProduct(Long id, ProductModel product) {
		return productRepository.findById(id).map(record -> {
			record.setName(product.getName());
			record.setQty(product.getQty());
			record.setSku(product.getSku());
			ProductModel updated = productRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
}
