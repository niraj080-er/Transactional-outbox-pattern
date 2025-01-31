package com.integra.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integra.order.common.dto.OrderRequestDTO;
import com.integra.order.entity.Order;
import com.integra.order.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<Order> saveOrder(OrderRequestDTO orderRequestDto) {
		Order createOrder=orderService.createOrder(orderRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
	}

}
