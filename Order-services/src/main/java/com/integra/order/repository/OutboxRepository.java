package com.integra.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integra.order.entity.OutboxEntity;

public interface OutboxRepository  extends JpaRepository<OutboxEntity, Long>{

	
}