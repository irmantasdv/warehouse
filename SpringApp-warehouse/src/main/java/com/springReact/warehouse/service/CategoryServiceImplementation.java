package com.springReact.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springReact.warehouse.model.Category;
import com.springReact.warehouse.repository.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryRepository cetegoryRepository;

	@Override
	public List<Category> gelAllCategories() {

		return cetegoryRepository.findAll();
	}

}
