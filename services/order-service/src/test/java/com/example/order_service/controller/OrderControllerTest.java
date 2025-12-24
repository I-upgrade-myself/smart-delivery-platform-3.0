package com.example.order_service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateOrder() throws Exception {
        String json = "{\"productId\":1,\"quantity\":2}";
        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void testGetOrder() throws Exception {
        mockMvc.perform(get("/orders/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testListOrders() throws Exception {
        mockMvc.perform(get("/orders?page=0&size=10"))
                .andExpect(status().isOk());
    }
}
