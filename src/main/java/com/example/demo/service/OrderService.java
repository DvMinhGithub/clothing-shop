package com.example.demo.service;

import com.example.demo.enums.OrderStatus;
import com.example.demo.model.dto.OrderDetailDto;
import com.example.demo.model.dto.StatisticOrderDto;
import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.request.WebhookRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<ResponseApi<?>> createOrder(CreateOrderRequest createOrderRequest);

    ResponseEntity<ResponseApi<?>> changeOrderStatus(WebhookRequest webhookRequest);

    ResponseEntity<ResponseApi<?>> cancelOrder(Long orderId);

    ResponseEntity<ResponseApi<List<OrderDetailDto>>> getListOrder(OrderStatus orderStatus);

    ResponseEntity<ResponseApi<OrderDetailDto>> getOrderDetail(Long orderId);

    ResponseEntity<ResponseApi<StatisticOrderDto>> getStatisticOrder();
}
