package com.example.demo.controller;

import com.example.demo.enums.OrderStatus;
import com.example.demo.model.dto.OrderDetailDto;
import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.request.WebhookRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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
    public ResponseEntity<ResponseApi<?>> createOrder(Principal principal, @RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(principal, createOrderRequest);
    }

    @Operation(summary = "Change order status", description = "Change order status")
    @PostMapping("/changeOrderStatus")
    public ResponseEntity<ResponseApi<?>> changeOrderStatus(@RequestBody WebhookRequest webhookRequest) {
        return orderService.changeOrderStatus(webhookRequest);
    }

    @Operation(summary = "Cancel order", description = "Cancel order")
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/cancel/{orderId}")
    public ResponseEntity<ResponseApi<?>> cancelOrder(@PathVariable("orderId") Long orderId) {
        return orderService.cancelOrder(orderId);
    }

    @Operation(summary = "Get list order", description = "Get list order")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/getAll")
    public ResponseEntity<ResponseApi<List<OrderDetailDto>>> getListOrder(
            Principal principal,
            @RequestParam(value = "status", required = false) OrderStatus orderStatus) {
        return orderService.getListOrder(principal, orderStatus);
    }

    @Operation(summary = "Get order detail", description = "Get order detail")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/detail/{orderId}")
    public ResponseEntity<ResponseApi<OrderDetailDto>> getListOrder(@PathVariable("orderId") Long orderId) {
        return orderService.getOrderDetail(orderId);
    }
}
