package com.example.shopping_cart_order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopping_cart_order.entity.Order;
import com.example.shopping_cart_order.exception.BaseResponse;
import com.example.shopping_cart_order.exception.OrderServiceException;
import com.example.shopping_cart_order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public BaseResponse<Long> insert(Order order) throws OrderServiceException {

		Order orderTemp = orderRepository.save(order);

		BaseResponse<Long> baseResponse = new BaseResponse<>();

		baseResponse.setData(orderTemp.getId());

		return baseResponse;

	}

	public BaseResponse<List<Order>> getAllOrders() {

		List<Order> list = orderRepository.findAll();

		BaseResponse<List<Order>> baseResponse = new BaseResponse<>();

		baseResponse.setData(list);

		return baseResponse;
	}

	public BaseResponse<Order> getOrderById(Long id) {

		BaseResponse<Order> baseResponse = new BaseResponse<>();
		baseResponse.setData(orderRepository.findById(id).get());
		return baseResponse;

	}

}
