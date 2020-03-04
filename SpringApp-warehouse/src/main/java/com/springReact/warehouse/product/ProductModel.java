package com.springReact.warehouse.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "ProductModel", tags = { "Product model" })
@Entity
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "id", value = "2", notes = "automatically generated value")
	private Long id;
	@ApiModelProperty(name = "sku", value = "A12", notes = "SKU is a unique numerical identifying number that refers to a specific stock item in a retailer's inventory or product catalog.")
	private String sku;
	@ApiModelProperty(name = "name", value = "demo name", notes = "product name")
	private String name;
	@ApiModelProperty(name = "qty", value = "5", notes = "product quantity")
	private int qty;

	public ProductModel(String sku, String name, int qty) {
		super();
		this.sku = sku;
		this.name = name;
		this.qty = qty;
	}

	public ProductModel() {
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", sku=" + sku + ", name=" + name + ", qty=" + qty + "]";
	}

}
