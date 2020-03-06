package com.springReact.warehouse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Category", tags = { "Category model" })
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "id", value = "2", notes = "automatically generated value")
	private Long id;
	@ApiModelProperty(name = "name", value = "demo name", notes = "product name")
	private String name;
	@ApiModelProperty(name = "decription", value = "text", notes = "category description")
	private String decription;
	@ApiModelProperty(name = "products", value = "text", notes = "list of products in category")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<ProductModel> products;

	public Category(String name, String decription) {
		this.name = name;
		this.decription = decription;
	}

	public Category() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", decription=" + decription + "]";
	}

}
