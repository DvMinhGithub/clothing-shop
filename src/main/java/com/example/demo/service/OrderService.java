package com.example.demo.service;

import com.example.demo.model.request.CreateOrderRequest;
import com.example.demo.model.request.WebhookRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

public interface OrderService {

    ResponseEntity<ResponseApi<?>> createOrder(Principal principal, CreateOrderRequest createOrderRequest) ;

    ResponseEntity<ResponseApi<?>> changeOrderStatus(WebhookRequest webhookRequest);

    ResponseEntity<ResponseApi<?>> cancelOrder(Long orderId);
}
