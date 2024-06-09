package com.example.demo.service;

import com.example.demo.enums.OrderStatus;
import com.example.demo.model.dto.OrderDetailDto;
import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.request.WebhookRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

public interface OrderService {
    ResponseEntity<ResponseApi<?>> createOrder(Principal principal, CreateOrderRequest createOrderRequest);

    ResponseEntity<ResponseApi<?>> changeOrderStatus(WebhookRequest webhookRequest);

    ResponseEntity<ResponseApi<?>> cancelOrder(Long orderId);

    ResponseEntity<ResponseApi<List<OrderDetailDto>>> getListOrder(Principal principal, OrderStatus orderStatus);

    ResponseEntity<ResponseApi<OrderDetailDto>> getOrderDetail(Long orderId);
}
