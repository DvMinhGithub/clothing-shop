package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Double priceAtOrderTime;

    private Integer quantity;

    private String productName;

    private String productImage;

    private Long orderId;

    private Long productId;
}
