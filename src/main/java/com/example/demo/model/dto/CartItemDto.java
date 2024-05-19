package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemDto {
    private Long id;

    private Integer quantity;

    private String productImage;

    private String productName;
}
