package com.example.order_service.service;
import org.springframework.stereotype.Service;

import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Order> list(int page, int size) {
        return repository.findAll();
    }
}
