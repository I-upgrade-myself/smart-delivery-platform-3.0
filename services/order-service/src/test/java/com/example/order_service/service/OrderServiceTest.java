package com.example.order_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.order_service.entity.Order;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceTest {

    @Autowired
    private OrderService service;

    @Test
    void testCreateAndGetOrder() {
        Order order = new Order(null, 1L, 2);
        Order saved = service.create(order);
        assertNotNull(saved.getId());

        Order fetched = service.get(saved.getId());
        assertEquals(1L, fetched.getProductId());
    }

    @Test
    void testListOrders() {
        List<Order> orders = service.list(0, 10);
        assertNotNull(orders);
    }
}
