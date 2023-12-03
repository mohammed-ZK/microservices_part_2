package com.example.shopping_cart.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.shopping_cart.entity.Product;

public class CartDto {

	private Long id;
	private BigDecimal totalprice;
	private List<Product> products = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
