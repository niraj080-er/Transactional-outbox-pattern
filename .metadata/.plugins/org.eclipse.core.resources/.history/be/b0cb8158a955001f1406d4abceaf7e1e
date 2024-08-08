package com.integra.order.common.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.integra.order.entity.Order;
import com.integra.order.entity.OutboxEntity;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderEntityToOutboxEntityMapper {


    @SneakyThrows
    public OutboxEntity map(Order order) {
        return
        		OutboxEntity.builder()
                        .aggregatId(order.getId().toString())
                        .payload(new ObjectMapper().writeValueAsString(order))
                        .createdAt(new Date())
                        .isProcessed(false)
                        .build();
    }
}
