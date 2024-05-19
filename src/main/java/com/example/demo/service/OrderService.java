package com.example.demo.service;

import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

public interface OrderService {

    ResponseEntity<ResponseApi<?>> createOrder(Principal principal, CreateOrderRequest createOrderRequest);
}
