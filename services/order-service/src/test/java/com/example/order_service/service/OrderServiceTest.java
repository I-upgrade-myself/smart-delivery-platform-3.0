package com.example.order_service.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.order_service.dto.CreateOrderRequest;
import com.example.order_service.dto.OrderDto;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceTest {

    @Autowired
    private OrderService service;

    @Test
    void testCreateAndGetOrder() {
        
        CreateOrderRequest request = new CreateOrderRequest();
        request.setCustomerName("John Doe");
        request.setProduct("Product A");
        request.setQuantity(2);

     
        OrderDto saved = service.create(request);
        assertNotNull(saved.getId());

        OrderDto fetched = service.get(saved.getId());
        assertNotNull(fetched);
        assertEquals("Product A", fetched.getProduct());
        assertEquals(2, fetched.getQuantity());
    }

    @Test
    void testListOrders() {
        List<OrderDto> orders = service.list();
        assertNotNull(orders);
    }
}
