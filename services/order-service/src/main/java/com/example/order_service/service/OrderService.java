package com.example.order_service.service;
import org.springframework.stereotype.Service;

import com.example.order_service.dto.CreateOrderRequest;
import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderDto create(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setProduct(request.getProduct());
        order.setQuantity(request.getQuantity());
        order.setCreatedAt(LocalDateTime.now());

        Order saved = repository.save(order);
        return mapToDto(saved);
    }

    public OrderDto get(Long id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    public List<OrderDto> list() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private OrderDto mapToDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setProduct(order.getProduct());
        dto.setQuantity(order.getQuantity());
        dto.setCreatedAt(order.getCreatedAt());
        return dto;
    }
}
