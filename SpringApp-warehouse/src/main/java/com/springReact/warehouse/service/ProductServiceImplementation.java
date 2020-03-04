package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springReact.warehouse.ProductRepository.ProductRepository;
import com.springReact.warehouse.product.ProductModel;

@Service
public class ProductServiceImplementation implements ProductService {

	@Autowired 
	ProductRepository productRepository;
	
	public List<ProductModel> getProducts() {
		
		return productRepository.findAll();
	}

}
