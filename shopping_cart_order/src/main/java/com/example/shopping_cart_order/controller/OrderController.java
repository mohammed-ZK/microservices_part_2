package com.example.shopping_cart_order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopping_cart_order.entity.Order;
import com.example.shopping_cart_order.exception.BaseResponse;
import com.example.shopping_cart_order.exception.OrderServiceException;
import com.example.shopping_cart_order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Value("${server.port}")
	private Long port;

	@PostMapping("/order")
	public ResponseEntity<BaseResponse<Long>> insert(@RequestBody Order order) throws OrderServiceException {

		BaseResponse<Long> baseResponse = new BaseResponse<>();
		baseResponse.setMessage(port.toString());
		baseResponse.setData(orderService.insert(order).getData());
		return ResponseEntity.ok(baseResponse);

	}

	@GetMapping("/orders")
	public ResponseEntity<BaseResponse<List<Order>>> getAllOrders() throws OrderServiceException {

		BaseResponse<List<Order>> baseResponse = new BaseResponse<>();
		baseResponse.setMessage(port.toString());
		baseResponse.setData(orderService.getAllOrders().getData());
		return ResponseEntity.ok(baseResponse);

	}

	@GetMapping("/order/{id}")
	public ResponseEntity<BaseResponse<Order>> getOrderById(@PathVariable Long id) throws OrderServiceException {

		BaseResponse<Order> baseResponse = new BaseResponse<>();
		baseResponse.setMessage(port.toString());
		baseResponse.setData(orderService.getOrderById(id).getData());
		return ResponseEntity.ok(baseResponse);
	}

}
