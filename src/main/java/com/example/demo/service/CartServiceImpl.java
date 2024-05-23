package com.example.demo.service;

import com.example.demo.mapper.CartMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.CartItemDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.AddToCartRequest;
import com.example.demo.model.request.UpdateCartRequest;
import com.example.demo.model.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService {
    private final CartMapper cartMapper;

    private final UserMapper userMapper;

    public CartServiceImpl(CartMapper cartMapper, UserMapper userMapper) {
        this.cartMapper = cartMapper;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<ResponseApi<?>> addToCart(Principal principal, AddToCartRequest addToCartRequest) {
        log.info("Start API: addToCart with parameters: ({})", addToCartRequest);
        try {
            UserDto user = userMapper.getByEmail(principal.getName());
            List<CartItemDto> listCartItem = cartMapper.getByUserId(user.getId());

            for (CartItemDto cartItem : listCartItem) {
                if (cartItem.getProductId().equals(addToCartRequest.getIdProduct())) {
                    cartMapper.updateCartItemQuantity(cartItem.getId(),
                            cartItem.getQuantity() + addToCartRequest.getQuantity());
                    log.info("End API: addToCart");
                    return new ResponseEntity<>(new ResponseApi<>("Add to cart success"), HttpStatus.OK);
                }
            }

            cartMapper.addToCart(user.getId(), addToCartRequest);
            log.info("End API: addToCart");
            return new ResponseEntity<>(new ResponseApi<>("Add to cart success", 200), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error API: addToCart with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ResponseApi<List<CartItemDto>>> getCartInformation(Principal principal) {
        log.info("Start API: getCartInformation");
        UserDto user = userMapper.getByEmail(principal.getName());
        List<CartItemDto> listCartItem = cartMapper.getByUserId(user.getId());
        log.info("End API: getCartInformation");
        return new ResponseEntity<>(new ResponseApi<>("Get cart success", listCartItem), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi<?>> updateCartInformation(UpdateCartRequest updateCartRequest) {
        log.info("Start API: updateCartInformation");
        try {
            if (updateCartRequest.getQuantity() == 0) {
                cartMapper.deleteCartItem(updateCartRequest.getCartItemId());
                log.info("End API: updateCartInformation");
                return new ResponseEntity<>(new ResponseApi<>("Update cart success"), HttpStatus.OK);
            }
            cartMapper.updateCartItemQuantity(updateCartRequest.getCartItemId(), updateCartRequest.getQuantity());
            log.info("End API: updateCartInformation");
            return new ResponseEntity<>(new ResponseApi<>("Update cart success"), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error API: updateCartInformation with message: {}", e.getMessage());
            return new ResponseEntity<>(new ResponseApi<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
