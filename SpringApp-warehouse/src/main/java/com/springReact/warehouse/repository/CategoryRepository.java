package com.springReact.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springReact.warehouse.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
