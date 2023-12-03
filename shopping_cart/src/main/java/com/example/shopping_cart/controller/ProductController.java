package com.example.shopping_cart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_cart.Exception.BaseResponse;
import com.example.shopping_cart.Exception.ProductException;
import com.example.shopping_cart.dto.ProductDto;
import com.example.shopping_cart.entity.Product;
import com.example.shopping_cart.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/v1/product")
	public BaseResponse<ProductDto> insert(@RequestBody @Valid Product products) throws ProductException {
		log.info("=====>1");
		BaseResponse<ProductDto> baseResponse = productService.insert(products);
		return baseResponse;
	}

	@GetMapping("/v1/products")
	public BaseResponse<List<ProductDto>> getProducts() {
		BaseResponse<List<ProductDto>> baseResponse = new BaseResponse<>();
		baseResponse.setData(productService.getProducts());
		return baseResponse;
	}

	@PutMapping("/v1/products/{id}")
	public BaseResponse<Product> updateProduct(@RequestBody @Valid Product products, @PathVariable Long id) {
		productService.updateProduct(products, id);
		return new BaseResponse<Product>();
	}

	@DeleteMapping("/v1/products/{id}")
	public BaseResponse<Void> deleteProduct(@PathVariable Long id) throws ProductException {
		return productService.deleteProduct(id);
	}

	@PostMapping("/v1/{id1}/products/{id2}")
	public BaseResponse<Void> addProductToCart(@PathVariable Long id1, @PathVariable Long id2) throws ProductException {
		log.info("=====>");
		productService.addProductToCart(id1, id2);
		return new BaseResponse<Void>();
	}

	@DeleteMapping("/v1/{id1}/products/{id2}")
	public BaseResponse<Void> deleteProductFromCart(@PathVariable Long id1, @PathVariable Long id2)
			throws ProductException {
		log.info("=====>");
		productService.deleteProductFromCart(id1, id2);
		return new BaseResponse<Void>();
	}

}
