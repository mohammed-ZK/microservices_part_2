package com.example.shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.shopping_cart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(@Param("name") String name);
}
