package com.integra.order.common.mapper;


import org.springframework.stereotype.Component;

import com.integra.order.common.dto.OrderRequestDTO;
import com.integra.order.entity.Order;

import java.util.Date;

@Component
public class OrderDTOtoEntityMapper {


    public Order map(OrderRequestDTO orderRequestDTO) {
        return
                Order.builder()
                        .customerId(orderRequestDTO.getCustomerId())
                        .name(orderRequestDTO.getName())
                        .productType(orderRequestDTO.getProductType())
                        .quantity(orderRequestDTO.getQuantity())
                        .price(orderRequestDTO.getPrice())
                        .orderDate(new Date())
                        .build();
    }
}
