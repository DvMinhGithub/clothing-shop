package com.example.demo.mapper;

import com.example.demo.enums.OrderStatus;
import com.example.demo.model.dto.OrderDetailDto;
import com.example.demo.model.dto.OrderDto;
import com.example.demo.model.dto.OrderItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    void create(@Param("orderInfo") OrderDto orderDto);

    void setCheckOutUrl(@Param("orderId") Long orderId, @Param("checkoutUrl") String checkoutUrl);

    void createOrderItem(@Param("orderItemInfo") OrderItemDto orderItemDto);

    void changeOrderStatus(@Param("orderCode") Long orderCode, @Param("orderStatus") OrderStatus orderStatus);

    List<OrderDetailDto> getListOrder(@Param("userId") Long userId, @Param("orderStatus") OrderStatus orderStatus);

    OrderDetailDto getOrderDetail(@Param("orderId") Long orderId);

    Integer getTotalOrder();

    Integer getOrderPending();

    Integer getOrderSuccess();

    Integer getOrderCancel();
}
