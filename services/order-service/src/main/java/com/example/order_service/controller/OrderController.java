package com.example.order_service.controller;


import org.springframework.web.bind.annotation.*;

import com.example.order_service.entity.Order;
import com.example.order_service.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Orders", description = "Order management API")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }
    @Operation(summary = "Create order")
    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }
    @Operation(summary = "Get order by id")
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

