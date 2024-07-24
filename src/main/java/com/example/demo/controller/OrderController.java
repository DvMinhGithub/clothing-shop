package com.example.demo.controller;

import com.example.demo.enums.OrderStatus;
import com.example.demo.model.dto.OrderDetailDto;
import com.example.demo.model.dto.StatisticOrderDto;
import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.request.WebhookRequest;
import com.example.demo.model.response.ResponseApi;
import com.example.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Create order", description = "Create order")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/create")
    public ResponseEntity<ResponseApi<?>> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }

    @Operation(summary = "Change order status", description = "Change order status")
    @PostMapping("/changeOrderStatus")
    public ResponseEntity<ResponseApi<?>> changeOrderStatus(@RequestBody WebhookRequest webhookRequest) {
        return orderService.changeOrderStatus(webhookRequest);
    }

    @Operation(summary = "Cancel order", description = "Cancel order")
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/cancel/{orderCode}")
    public ResponseEntity<ResponseApi<?>> cancelOrder(@PathVariable("orderCode") Long orderCode) {
        return orderService.cancelOrder(orderCode);
    }

    @Operation(summary = "Get list order", description = "Get list order")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/getAll")
    public ResponseEntity<ResponseApi<List<OrderDetailDto>>> getListOrder(@RequestParam(value = "status", required = false) OrderStatus orderStatus) {
        return orderService.getListOrder(orderStatus);
    }

    @Operation(summary = "Get order detail", description = "Get order detail")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/detail/{orderId}")
    public ResponseEntity<ResponseApi<OrderDetailDto>> getListOrder(@PathVariable("orderId") Long orderId) {
        return orderService.getOrderDetail(orderId);
    }

    @Operation(summary = "Get statistic order", description = "Get statistic order")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/statistic/order")
    public ResponseEntity<ResponseApi<StatisticOrderDto>> getStatisticOrder() {
        return orderService.getStatisticOrder();
    }
}
