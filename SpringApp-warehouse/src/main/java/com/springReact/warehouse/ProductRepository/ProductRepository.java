package com.springReact.warehouse.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springReact.warehouse.product.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
