package com.example.demo.service;

import com.example.demo.model.dto.CartItemDto;
import com.example.demo.model.request.AddToCartRequest;
import com.example.demo.model.request.UpdateCartRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.List;

public interface CartService {
    ResponseEntity<ResponseApi<?>> addToCart(Principal principal, AddToCartRequest addToCartRequest);

    ResponseEntity<ResponseApi<List<CartItemDto>>> getCartInformation(Principal principal);

    ResponseEntity<ResponseApi<?>> updateCartInformation(UpdateCartRequest updateCartRequest);
}
