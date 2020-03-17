package com.springReact.warehouse.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springReact.warehouse.model.ProductModel;
import com.springReact.warehouse.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(value = "ProductController", tags = { "ProductModel controller" })
@SwaggerDefinition(tags = { @Tag(name = "getProducts()", description = "returns all products"),
		@Tag(name = "findProductById(long id)", description = "returns one product"),
		@Tag(name = "deletePrById(long id)", description = "dlete product by id"),
		@Tag(name = "postProduct(ProductModel product)", description = "create new product"),
		@Tag(name = "updateProduct(ProductModel product)", description = "create new product") })
@CrossOrigin
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
	@DeleteMapping(path = "/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable long id) {
		return productService.deleteProduct(id);
	}

	@ApiOperation(value = "create new product", tags = "postProduct(ProductModel product)")
	@PostMapping("/products/product")
	public ResponseEntity<ProductModel> postProduct(ProductModel product) {
		return productService.createProduct(product);
	}

	@ApiOperation(value = "update the product", tags = "updateProduct(ProductModel product)")
	@PutMapping("/products/{id}")
	public ResponseEntity<ProductModel> updateProductModel(@RequestParam Long id,@RequestBody ProductModel product) {
		return productService.updateProduct(id, product);
	}
}
