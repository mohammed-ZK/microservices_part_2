package com.example.shopping_cart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.example.shopping_cart.Exception.BaseResponse;
import com.example.shopping_cart.Exception.ProductException;
import com.example.shopping_cart.dto.ProductDto;
import com.example.shopping_cart.entity.Cart;
import com.example.shopping_cart.entity.Product;
import com.example.shopping_cart.mapper.ProductMapper;
import com.example.shopping_cart.mapper.ProductMapperImpl;
import com.example.shopping_cart.repository.CartRepository;
import com.example.shopping_cart.repository.ProductRepository;

@Service
@EnableCaching
public class ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	private ProductMapper productMapper = new ProductMapperImpl();

	@CacheEvict(key = "#root.methodName", value = "AllProoducts", allEntries = true)
	public BaseResponse<ProductDto> insert(Product products) throws ProductException {
		log.info("======>" + products.getName());

		Product product = productRepository.save(products);
		ProductDto productDto = productMapper.mapToDto(product);
		log.info("======>" + products.getName());
		BaseResponse<ProductDto> baseResponse = new BaseResponse<>();
		baseResponse.setData(productDto);
		return baseResponse;

	}

	@Cacheable(key = "#root.methodName", value = "AllProoducts")
	public List<ProductDto> getProducts() {

		List<Product> products = productRepository.findAll();
		List<ProductDto> productDtos = new ArrayList<>();
		for (Product product : products) {
			ProductDto productDto = productMapper.mapToDto(product);
			productDtos.add(productDto);
		}

		return productDtos;
	}

	public BaseResponse<Product> updateProduct(Product product, Long id) {
		Product product2 = productRepository.findById(id).get();
		log.info("========>id" + id);
		product2.setDescription(product.getDescription());
		log.info("========>id" + product.getDescription());
		product2.setName(product.getName());
		log.info("========>id" + product.getName());
		product2.setPrice(product.getPrice());
		log.info("========>id" + product.getPrice());
		productRepository.save(product2);
		log.debug("Save in the database");
		BaseResponse<Product> baseResponse = new BaseResponse<>();
		baseResponse.setData(product2);
		return baseResponse;
	}

	@CacheEvict(key = "#root.methodName", value = "AllProoducts", allEntries = true)
	public BaseResponse<Void> deleteProduct(Long id) throws ProductException {
		try {
			productRepository.deleteById(id);
			return new BaseResponse<>();
		} catch (Exception e) {
			// TODO: handle exception
			throw new ProductException("the product is not found");
		}
	}

	public BaseResponse<Void> addProductToCart(Long id1, Long id2) throws ProductException {
		try {

			Cart cart = cartRepository.findById(id1).get();
			log.info("=====>" + id1);
			Product product = productRepository.findById(id2).get();
			log.info("=====>" + id2);
			BigDecimal Sum = cart.getTotalprice();
			log.info("=====>" + Sum);
			List<BigDecimal> invoices = new LinkedList<>();
			List<Product> list = new ArrayList<>();
			invoices.add(product.getPrice());
			invoices.add(Sum);
			Sum = invoices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
			cart.setTotalprice(Sum);
			log.info("=====>" + Sum);
			list.add(product);
			List<Product> list2 = cart.getProducts();
			for (Product product2 : list2) {
				list.add(product2);
			}
			cart.setProducts(list);

			cartRepository.save(cart);

			return new BaseResponse<>();
		} catch (Exception e) {
			throw new ProductException("the Cart or Product is not found");
		}
	}

	public BaseResponse<Void> deleteProductFromCart(Long id1, Long id2) throws ProductException {
		try {

			Cart cart = cartRepository.findById(id1).get();
			log.info("==========>" + id1);
			List<Product> products = cart.getProducts();
			log.info("==========>" + id2);

			BigDecimal bigDecimal = BigDecimal.ZERO;

			for (Product product : products) {
				log.info("======>" + product.getName());
				if (id2 == product.getId()) {
					bigDecimal = product.getPrice();
				}
			}

			products.removeIf(id -> id.getId() == id2);

			cart.setTotalprice(cart.getTotalprice().subtract(bigDecimal));

			for (Product product : products) {
				log.info("======>" + product.getName());
			}

			cart.setProducts(products);
			cartRepository.save(cart);

			return new BaseResponse<>();
		} catch (Exception e) {
			throw new ProductException("the Cart or Product is not found");
		}

	}
}
