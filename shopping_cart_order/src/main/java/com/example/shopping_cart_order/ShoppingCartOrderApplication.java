package com.example.shopping_cart_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingCartOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartOrderApplication.class, args);
	}

}
