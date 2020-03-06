package com.springReact.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springReact.warehouse.model.ProductModel;


public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
