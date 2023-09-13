package com.example.tastyapp.repositories;

import com.example.tastyapp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findOrderByUserOrderId(Long userId);

}
