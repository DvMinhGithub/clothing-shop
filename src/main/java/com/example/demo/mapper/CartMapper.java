package com.example.demo.mapper;

import com.example.demo.model.dto.CartItemDto;
import com.example.demo.model.request.AddToCartRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartItemDto> getByUserId(@Param("userId") Long userId);

    List<CartItemDto> getByCartItemId(@Param("listCartItemIds") List<Long> listCartItemIds);

    void addToCart(@Param("userId") Long userId, @Param("addToCartInfo") AddToCartRequest addToCartRequest);

    void updateCartItemQuantity(@Param("cartItemId") Long cartItemId,
                                @Param("quantity") Integer quantity);

    void deleteCartItem(@Param("cartItemId") Long cartItemId);

    void deleteListCartItem(@Param("listCartItemIds") List<Long> listCartItemIds);
}
