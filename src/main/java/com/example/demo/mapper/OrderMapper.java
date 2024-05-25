package com.example.demo.mapper;

import com.example.demo.model.dto.OrderDto;
import com.example.demo.model.dto.OrderItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    void create(@Param("orderInfo")OrderDto orderDto);

    void createOrderItem(@Param("orderItemInfo")OrderItemDto orderItemDto);
}
