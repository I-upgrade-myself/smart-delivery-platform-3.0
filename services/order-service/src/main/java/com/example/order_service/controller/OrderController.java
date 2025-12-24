package com.example.order_service.controller;


import org.springframework.web.bind.annotation.*;

import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Order> list(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size) {
        return service.list(page, size);
    }
}

