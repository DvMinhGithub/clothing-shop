package com.example.demo.mapper;

import com.example.demo.enums.OrderStatus;
import com.example.demo.model.dto.OrderDto;
import com.example.demo.model.dto.OrderItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void create(@Param("orderInfo") OrderDto orderDto);

    void setCheckOutUrl(@Param("orderId")Long orderId, @Param("checkoutUrl") String checkoutUrl);

    void createOrderItem(@Param("orderItemInfo") OrderItemDto orderItemDto);

    void changeOrderStatus(@Param("orderId") Long orderId, @Param("orderStatus")OrderStatus orderStatus);
}
