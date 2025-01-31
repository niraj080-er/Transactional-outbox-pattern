package com.integra.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integra.order.common.dto.OrderRequestDTO;
import com.integra.order.common.mapper.OrderDTOtoEntityMapper;
import com.integra.order.common.mapper.OrderEntityToOutboxEntityMapper;
import com.integra.order.entity.Order;
import com.integra.order.entity.OutboxEntity;
import com.integra.order.repository.OrderRepository;
import com.integra.order.repository.OutboxRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderDTOtoEntityMapper orderDtoToEntityMapper;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderEntityToOutboxEntityMapper orderEntityToOutboxEntityMapper;

	@Autowired
	private OutboxRepository outboxRepository;

	@Transactional
	public Order createOrder(OrderRequestDTO orderRequestDto) {
		Order order= orderDtoToEntityMapper.map(orderRequestDto);
		orderRepository.save(order);
		OutboxEntity outbox=	orderEntityToOutboxEntityMapper.map(order);
		outboxRepository.save(outbox);
		return order;
	}

}
