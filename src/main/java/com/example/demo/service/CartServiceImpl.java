//package com.example.demo.service;
//
//import com.example.demo.model.dto.CartItemDto;
//import com.example.demo.model.request.AddToCartRequest;
//import com.example.demo.model.request.UpdateCartInformationRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.security.Principal;
//import java.util.List;
//
//import com.example.demo.entity.*;
//import com.example.demo.model.response.ResponseApi;
//import com.example.demo.repository.*;
//
//@Service
//@Slf4j
//public class CartServiceImpl implements CartService{
//
//    private final UserRepository userRepository;
//
//    private final CartItemRepository cartItemRepository;
//
//    private final ProductRepository productRepository;
//
//    public CartServiceImpl(UserRepository userRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
//        this.userRepository = userRepository;
//        this.cartItemRepository = cartItemRepository;
//        this.productRepository = productRepository;
//    }
//
//    public ResponseEntity<ResponseApi<?>> addToCart(Principal principal, AddToCartRequest addToCartRequest) {
//        log.info("Start API: addToCart with parameters: ({})", addToCartRequest);
//        try {
//            User user = userRepository.findByEmail(principal.getName());
//            List<CartItem> listCartItem = cartItemRepository.findByUserId(user.getId());
//
//            for (CartItem cartItem : listCartItem) {
//                if (cartItem.getProduct().getId().equals(addToCartRequest.getIdProduct())) {
//                    cartItem.setQuantity(cartItem.getQuantity() + addToCartRequest.getQuantity());
//                    cartItemRepository.save(cartItem);
//                    log.info("End API: addToCart");
//                    return new ResponseEntity<>(new ResponseApi<>("Add to cart success", 200), HttpStatus.OK);
//                }
//            }
//
//            CartItem cartItem = new CartItem();
//            Product product = productRepository.findById(addToCartRequest.getIdProduct()).get();
//            cartItem.setProduct(product);
//            cartItem.setQuantity(addToCartRequest.getQuantity());
//            cartItem.setUser(user);
//            cartItemRepository.save(cartItem);
//            log.info("End API: addToCart");
//            return new ResponseEntity<>(new ResponseApi<>("Add to cart success", 200), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Error API: addToCart with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    public ResponseEntity<ResponseApi<List<CartItemDto>>> getCartInformation(Principal principal) {
//        log.info("Start API: getCartInformation");
//        User user = userRepository.findByEmail(principal.getName());
//        List<CartItem> listCartItem = cartItemRepository.findByUserId(user.getId());
//        List<CartItemDto> listCartItemDto = listCartItem.stream().map(
//                cartItem -> {
//                    CartItemDto cartItemDto = new CartItemDto();
//                    cartItemDto.setId(cartItem.getId());
//                    cartItemDto.setProductName(cartItem.getProduct().getName());
//                    cartItemDto.setQuantity(cartItem.getQuantity());
//                    cartItemDto.setProductImage(cartItem.getProduct().getProductImage());
//                    return cartItemDto;
//                }
//        ).toList();
//        log.info("End API: getCartInformation");
//        return new ResponseEntity<>(new ResponseApi<>("Get cart success", 200, listCartItemDto), HttpStatus.OK);
//    }
//
//    public ResponseEntity<ResponseApi<?>> updateCartInformation(UpdateCartInformationRequest updateCartInformationRequest) {
//        log.info("Start API: updateCartInformation");
//        try {
//            CartItem cartItem = cartItemRepository.findById(updateCartInformationRequest.getCartItemId()).get();
//            if(updateCartInformationRequest.getQuantity() == 0){
//                cartItemRepository.delete(cartItem);
//                log.info("End API: updateCartInformation");
//                return new ResponseEntity<>(new ResponseApi<>("Update cart success", 200), HttpStatus.OK);
//            }
//            cartItem.setQuantity(updateCartInformationRequest.getQuantity());
//            cartItemRepository.save(cartItem);
//            log.info("End API: updateCartInformation");
//            return new ResponseEntity<>(new ResponseApi<>("Update cart success", 200), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("Error API: updateCartInformation with message: {}", e.getMessage());
//            return new ResponseEntity<>(new ResponseApi<>(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}
