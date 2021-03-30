package com.aprender.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprender.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{}