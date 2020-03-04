package com.springReact.warehouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springReact.warehouse.product.ProductModel;
import com.springReact.warehouse.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(value = "ProductController", tags = { "ProductModel controller" })
@SwaggerDefinition(tags = {
        @Tag(name = "getProducts", description = "returns all products")
})
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@ApiOperation(value = "returns List of all products",  tags = "getProducts")
	@GetMapping("/products")
	public List<ProductModel> getProducts() {
		return productService.getProducts();
	}
}
