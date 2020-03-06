package com.springReact.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springReact.warehouse.model.Category;
import com.springReact.warehouse.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping(path = "/categories")
	public List<Category> returnAllCategories() {

		return categoryService.gelAllCategories();
	}

}
