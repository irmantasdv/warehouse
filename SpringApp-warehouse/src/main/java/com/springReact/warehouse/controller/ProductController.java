package com.springReact.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springReact.warehouse.product.ProductModel;
import com.springReact.warehouse.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(value = "ProductController", tags = { "ProductModel controller" })
@SwaggerDefinition(tags = { @Tag(name = "getProducts()", description = "returns all products"),
		@Tag(name = "findProductById(long id)", description = "returns all products"),
		@Tag(name = "findProductById(long id)", description = "returns all products") })
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@ApiOperation(value = "returns List of all products", tags = "getProducts()")
	@GetMapping("/products")
	public List<ProductModel> getProducts() {
		return productService.getProducts();
	}

	@ApiOperation(value = "returns product by id", tags = "findProductById(long id)")
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<ProductModel> findProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}

	@ApiOperation(value = "delete product by id", tags = "deletePrById(long id)")
	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		return productService.deleteProduct(id);
	}
}
