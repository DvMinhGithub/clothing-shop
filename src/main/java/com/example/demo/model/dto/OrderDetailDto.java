package com.example.demo.model.dto;

import com.example.demo.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private Long id;

    private String address;

    private Timestamp createdAt;

    private String phoneNumber;

    private OrderStatus orderStatus;

    private Double totalPrice;

    private String voucherCode;

    private String checkoutUrl;

    private List<OrderItemDto> listOrderItem;
}
