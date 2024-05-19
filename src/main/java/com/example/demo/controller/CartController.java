//package com.example.demo.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.List;
//
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.service.CartService;
//import com.example.demo.model.dto.CartItemDto;
//import com.example.demo.model.request.AddToCartRequest;
//import com.example.demo.model.request.UpdateCartInformationRequest;
//
//@RestController
//@RequestMapping("/cart")
//public class CartController {
//
//    private final CartService cartService;
//
//    public CartController(CartService cartService) {
//        this.cartService = cartService;
//    }
//
//    @Operation(summary = "Add to cart", description = "Add to cart")
//    @Secured("CUSTOMER")
//    @PostMapping("/addToCart")
//    public ResponseEntity<ResponseApi<?>> addToCart(Principal principal, @RequestBody AddToCartRequest addToCartRequest) {
//        return cartService.addToCart(principal, addToCartRequest);
//    }
//
//    @Operation(summary = "Get cart information", description = "Get cart information")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured("CUSTOMER")
//    @GetMapping("/get")
//    public ResponseEntity<ResponseApi<List<CartItemDto>>> getCartInformation(Principal principal) {
//        return cartService.getCartInformation(principal);
//    }
//
//    @Operation(summary = "Update cart information", description = "Update cart information")
//    @SecurityRequirement(name = "Bearer Authentication")
//    @Secured("CUSTOMER")
//    @PutMapping("/update")
//    public ResponseEntity<ResponseApi<?>> updateCartInformation(@RequestBody UpdateCartInformationRequest updateCartInformationRequest) {
//        return cartService.updateCartInformation(updateCartInformationRequest);
//    }
//}
