package com.example.shopping_cart.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal totalprice;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id",unique = true)
//	User user = new User();
	
	@OneToMany
	private List<Product> products =new ArrayList<>();

	public Cart(Long id, BigDecimal totalprice) {
		super();
		this.id = id;
		this.totalprice = totalprice;
	}

	public Cart() {
		super();
	}

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

	public void setProducts(List<Product> list) {
		this.products = list;
		
	}
	
}

