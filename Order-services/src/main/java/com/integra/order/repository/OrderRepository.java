package com.integra.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.order.entity.Order;

public interface OrderRepository  extends JpaRepository<Order, String>{
	
	

}
