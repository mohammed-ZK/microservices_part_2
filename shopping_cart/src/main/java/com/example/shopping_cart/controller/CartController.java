package com.example.shopping_cart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_cart.Exception.BaseResponse;
import com.example.shopping_cart.Exception.ErrorInInsertException;
import com.example.shopping_cart.Exception.UserNotAuthenticatedException;
import com.example.shopping_cart.Exception.UserNotFoundException;
import com.example.shopping_cart.dto.CartDto;
import com.example.shopping_cart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	private static final Logger log = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@PostMapping()
	public ResponseEntity<BaseResponse<Long>> insert()
			throws ErrorInInsertException, UserNotFoundException, UserNotAuthenticatedException {
		log.info("======>error");
		BaseResponse<Long> baseResponse = new BaseResponse<>();
		baseResponse.setData(cartService.insert());
		return ResponseEntity.ok(baseResponse);
	}

	@GetMapping()
	public List<CartDto> getCarts() throws Exception {
		return cartService.getCarts();
	}

	@GetMapping("{id}")
	public BaseResponse<CartDto> getCartById(@PathVariable Long id) throws Exception {
		return cartService.getCart(id);
	}

	@DeleteMapping("{id}")
	public BaseResponse<Void> deleteCart(@PathVariable Long id) throws Exception {
		cartService.deleteCart(id);
		return new BaseResponse<>();
	}

	@GetMapping("test")
	public String getCartIdAndUserId() throws Exception {
		return "hello";
	}
}
