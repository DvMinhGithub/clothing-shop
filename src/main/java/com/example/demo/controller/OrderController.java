package com.example.demo.controller;

import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.request.WebhookRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Create order", description = "Create order")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/create")
    public ResponseEntity<ResponseApi<?>> createOrder(Principal principal,@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(principal, createOrderRequest);
    }

    @Operation(summary = "Change order status", description = "Change order status")
    @PostMapping("/changeOrderStatus")
    public ResponseEntity<?> changeOrderStatus(@RequestBody WebhookRequest webhookRequest) {
        return orderService.changeOrderStatus(webhookRequest);
    }

    @Operation(summary = "Cancel order", description = "Cancel order")
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable("orderId") Long orderId) {
        return orderService.cancelOrder(orderId);
    }
}
